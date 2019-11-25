package service.dubbo.api;

import service.dubbo.api.bean.Product;
import service.dubbo.api.bean.ShoppingCart;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */
public interface ShoppingCartServiceInterface {

    /*
    output: a list of shoppingcart id
     */
    public List<ShoppingCart> getShoppingCartItems(String uid);

    /*
    修改商品数量也可以用这个接口
     */
    public boolean addProductToShopppingCart(String uid, Product product, long num);

    public boolean deleteProductInShopppingCart(String uid, String pid);
}
