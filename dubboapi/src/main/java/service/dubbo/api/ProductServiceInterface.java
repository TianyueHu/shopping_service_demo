package service.dubbo.api;

import service.dubbo.api.bean.Product;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */
public interface ProductServiceInterface {

    /*
    output: a list of pid
     */
    public List<Product> getAllProduct();

    public boolean checkAndDetuctInventory(String pid, int num);

    public boolean replenishStock(String pid, int num);

    //public Product getProduct(String pid);

}
