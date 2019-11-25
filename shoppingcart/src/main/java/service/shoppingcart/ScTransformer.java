package service.shoppingcart;

/**
 * @author Zheting Hu
 * @date 2019-11-24
 */
public class ScTransformer {

    public static service.dubbo.api.bean.ShoppingCart transfrom(ShoppingCart sc){
        service.dubbo.api.bean.ShoppingCart ssc = new service.dubbo.api.bean.ShoppingCart();
        ssc.setNum(sc.getNum());
        ssc.setPid(sc.getPid());
        ssc.setSid(sc.getSid());
        ssc.setUnitPrice(sc.getUnitPrice());
        ssc.setUid(sc.getUid());
        ssc.setUpdateTimestamp(sc.getUpdateTimestamp());
        return ssc;
    }
}
