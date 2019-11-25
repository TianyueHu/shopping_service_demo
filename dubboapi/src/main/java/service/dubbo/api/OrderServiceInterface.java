package service.dubbo.api;

import service.dubbo.api.bean.OrderInfo;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */
public interface OrderServiceInterface {

    /*
    output: oid of new order
     */
    public String newOrder(String uid, String pid, long num, long totalPrices);

    public boolean orderCancel(String oid);

    public boolean updateOrderStatus(String oid, String status);

    OrderInfo getOrder(String oid);
}
