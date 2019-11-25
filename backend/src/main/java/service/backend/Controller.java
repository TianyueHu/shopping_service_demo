package service.backend;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.dubbo.api.*;
import service.dubbo.api.bean.Product;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */

@RestController
public class Controller {

    @Reference(timeout = 500)
    private LogisticsServiceInterface logisticsServiceInterface;
    @Reference(timeout = 500)
    private OrderServiceInterface orderServiceInterface;
    @Reference(timeout = 500)
    private ShoppingCartServiceInterface shoppingCartServiceInterface;
    @Reference(timeout = 500)
    private UserServiceInterface userServiceInterface;
    @Reference(timeout = 500)
    private ProductServiceInterface productServiceInterface;
    @Reference(timeout = 500)

    @GetMapping("/register")
    public String register(@RequestParam("name") String name,
                           @RequestParam("phone") String phone, @RequestParam("address") String address){
        return userServiceInterface.register(name, phone, address);
    }

    //账户充值
    @GetMapping("/accountRecharge")
    public boolean accountRecharge(@RequestParam("uid") String uid, @RequestParam("num") long num){
        return userServiceInterface.deposit(uid, num);
    }

    //查看所有商品
    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productServiceInterface.getAllProduct();
    }

    //将商品加入到购物车
    @GetMapping("/addProductToShopppingcart")
    public boolean addProductToShopppingcart(String uid, Product product, long num){
        return shoppingCartServiceInterface.addProductToShopppingCart(uid, product, num);
    }

    //修改购物车商品数量
    public void modifyQuantitiesOfProduct(String uid, Product product, long num){
        shoppingCartServiceInterface.addProductToShopppingCart(uid, product, num);
    }

    //补充库存
    public void replenishStock(String pid, int num){
        productServiceInterface.replenishStock(pid, num);
    }

    //生成订单
    public void generateOrder(){
        //shoppingcart service 检查商品库存并扣除
        //user service 获取用户信息
        //order service 创建订单信息


    }

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
