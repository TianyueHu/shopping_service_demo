package service.backend;

import com.alibaba.dubbo.config.annotation.Reference;
import essence.annotation.GlobalTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import service.dubbo.api.*;
import service.dubbo.api.bean.Product;
import service.dubbo.api.bean.User;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */

@RestController
public class Controller {

    private Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Reference(timeout = 10000, url = "dubbo://127.0.0.1:10085", application = "logistics-service")
    private LogisticsServiceInterface logisticsServiceInterface;
    @Reference(timeout = 10000, url = "dubbo://127.0.0.1:10084", application = "order-service")
    private OrderServiceInterface orderServiceInterface;
    @Reference(timeout = 10000, url = "dubbo://127.0.0.1:10081", application = "user-service")
    private UserServiceInterface userServiceInterface;
    @Reference(timeout = 10000, url = "dubbo://127.0.0.1:10083", application = "product-service")
    private ProductServiceInterface productServiceInterface;

    @GetMapping("/register")
    @GlobalTransaction
    public String register(@RequestParam("name") String name,
                           @RequestParam("phone") String phone, @RequestParam("address") String address){
        LOG.info("received a register request");
        return userServiceInterface.register(name, phone, address);
    }

    //账户充值
    @GetMapping("/accountRecharge")
    @GlobalTransaction
    public boolean accountRecharge(@RequestParam("uid") String uid, @RequestParam("num") long num){
        return userServiceInterface.deposit(uid, num);
    }

    @GetMapping("/getUser")
    @GlobalTransaction
    public User getUser(@RequestParam("uid") String uid){
        return userServiceInterface.getUser(uid);
    }

    @GetMapping("/deleteUser")
    @GlobalTransaction
    public boolean deleteUser(@RequestParam("uid") String uid){
        return userServiceInterface.deleteUser(uid);
    }

    @PostMapping("/newProduct")
    @GlobalTransaction
    public String newProduct(@RequestBody Product product){
        return productServiceInterface.newProduct(product);
    }

    //查看所有商品
    @GetMapping("/getAllProduct")
    @GlobalTransaction
    public List<Product> getAllProduct(){
        return productServiceInterface.getAllProduct();
    }

    //补充库存
    @GetMapping("/replenishStock")
    @GlobalTransaction
    public void replenishStock(@RequestParam("pid")String pid, @RequestParam("num")int num){
        productServiceInterface.replenishStock(pid, num);
    }

    //生成订单
    @GetMapping("/generateOrder")
    @GlobalTransaction
    public String generateOrder(@RequestParam("uid")String uid,
                                @RequestParam("num")int num,
                                @RequestParam("pid")String pid,
                                @RequestParam("test")String testController){
        //检查商品库存并扣除
        //扣除用户余额
        //创建订单信息
        //初始化物流信息
        String oid = "";
        long unitPrice = productServiceInterface.getProduct(pid).getUnitPrice();
        productServiceInterface.checkAndDetuctInventory(pid, num);
        try {
            if(testController != null && testController.equals("test2")){
                Thread.sleep(15*1000);
                throw new Exception();
            }
            long totalPrice = num * unitPrice;
            String address = userServiceInterface.checkAndDeductBalance(uid, totalPrice);
            try{

                if(testController != null && testController.equals("test1")){
                    Thread.sleep(15*1000);
                    throw new Exception();
                }

                oid = orderServiceInterface.newOrder(uid, pid, num, totalPrice);
                try{
                    logisticsServiceInterface.newLogistics(oid);
                }
                catch (Exception e){
                    userServiceInterface.deposit(uid, totalPrice);
                    productServiceInterface.replenishStock(pid, num);
                    orderServiceInterface.deleteOrder(oid);
                }
            }
            catch (Exception e){
                userServiceInterface.deposit(uid, totalPrice);
                productServiceInterface.replenishStock(pid, num);
            }
        }
        catch (Exception e){
            productServiceInterface.replenishStock(pid, num);
        }

        return oid;
    }

    @GlobalTransaction
    @GetMapping("/applyForRefund")
    public void applyForRefund(@RequestParam("oid")String oid){
        //order service 检查订单状态并修改为CANCEL
        //logistics service 检查配送状态并修改为CANCEL
        //user service 增加用户余额
        //product service 补偿库存

        service.dubbo.api.bean.OrderInfo orderInfo = orderServiceInterface.orderCancel(oid);
        try {
            String status = logisticsServiceInterface.updateLogisticsStatus(oid, "CANCEL");

            try{
                userServiceInterface.deposit(orderInfo.getUid(), orderInfo.getTotalPrice());
                try {
                    productServiceInterface.replenishStock(orderInfo.getPid(), orderInfo.getNum());

                }
                catch (Exception e){
                    orderServiceInterface.updateOrderStatus(oid, orderInfo.getStatus());
                    logisticsServiceInterface.updateLogisticsStatus(oid, status);
                    userServiceInterface.checkAndDeductBalance(orderInfo.getOid(), orderInfo.getTotalPrice());
                }
            }
            catch (Exception e){
                orderServiceInterface.updateOrderStatus(oid, orderInfo.getStatus());
                logisticsServiceInterface.updateLogisticsStatus(oid, status);
            }
        }
        catch (Exception e){
            orderServiceInterface.updateOrderStatus(oid, orderInfo.getStatus());
        }
    }

    @GlobalTransaction
    @GetMapping("/updateLogistics")
    public void updateLogistics(@RequestParam("oid") String oid,
                                @RequestParam("status") String status,
                                @RequestParam("test") String testController){
        String origin = logisticsServiceInterface.updateLogisticsStatus(oid, status);
        try{
            if(testController.equals("test3")){
                Thread.sleep(15 * 1000);
                throw new Exception();
            }
            orderServiceInterface.updateOrderStatus(oid, status);
        }
        catch (Exception e){
            logisticsServiceInterface.updateLogisticsStatus(oid, origin);
        }
    }


}
