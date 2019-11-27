package service.backend;

import com.alibaba.dubbo.config.annotation.Reference;
import essence.annotation.GlobalTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import service.dubbo.api.*;
import service.dubbo.api.bean.OrderInfo;
import service.dubbo.api.bean.Product;
import service.dubbo.api.bean.ShoppingCart;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */

@RestController
public class Controller {

    private Logger LOG = LoggerFactory.getLogger(Controller.class);
//    @Reference(version = "1.0.0", timeout = 500)
//    private LogisticsServiceInterface logisticsServiceInterface;
//    @Reference(version = "1.0.0", timeout = 500)
//    private OrderServiceInterface orderServiceInterface;
//    @Reference(version = "1.0.0", timeout = 500)
//    private ShoppingCartServiceInterface shoppingCartServiceInterface;
    @Reference(version = "1.0.0", timeout = 500)
    private UserServiceInterface userServiceInterface;
//    @Reference(version = "1.0.0", timeout = 500)
//    private ProductServiceInterface productServiceInterface;

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

    //查看所有商品
//    @GetMapping("/getAllProduct")
//    public List<Product> getAllProduct(){
//        return productServiceInterface.getAllProduct();
//    }
//
//    //将商品加入到购物车
//    @PostMapping("/addProductToShopppingcart")
//    public boolean addProductToShopppingcart(@RequestParam("uid")String uid, @RequestParam("num")long num, @RequestBody Product product){
//        return shoppingCartServiceInterface.addProductToShopppingCart(uid, product, num);
//    }
//
//    //修改购物车商品数量
//    @PostMapping("/modifyQuantitiesOfProduct")
//    public void modifyQuantitiesOfProduct(@RequestParam("uid")String uid, @RequestBody Product product, @RequestParam("num")long num){
//        shoppingCartServiceInterface.addProductToShopppingCart(uid, product, num);
//    }
//
//    //补充库存
//    @GetMapping("/replenishStock")
//    public void replenishStock(@RequestParam("uid")String pid, @RequestParam("num")int num){
//        productServiceInterface.replenishStock(pid, num);
//    }
//
//    //生成订单
//    @PostMapping("/generateOrder")
//    @GlobalTransaction
//    public String generateOrder(@RequestParam("uid")String uid,@RequestParam("num")int num, @RequestBody Product product){
//        //shoppingcart service
//        //检查商品库存并扣除
//        //user service 获取用户信息
//        //order service 创建订单信息
//        boolean enoughStock = productServiceInterface.checkAndDetuctInventory(product.getPid(), num);
//        if(enoughStock){
//            long totalPrice = num * product.getUnitPrice();
//            shoppingCartServiceInterface.deleteProductInShopppingCart(uid, product.getPid());
//            String oid = orderServiceInterface.newOrder(uid, product.getPid(), num, totalPrice);
//
//            return oid;
//        }
//        return null;
//    }

    @GetMapping("/orderPayment")
    @GlobalTransaction
    public void orderPayment(){
        //user service 检查用户余额并扣除
        //logistics service 新增物流信息
        //order service 更新订单状态


    }

    public void applyForRefund(){
        //order service 检查订单状态并修改为CANCEL
        //logistics service 检查配送状态并修改为CANCEL
        //user service 增加用户余额
        //product service 补偿库存

    }
}
