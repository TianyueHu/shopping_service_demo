package service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    public OrderInfo getOrderByOid(String oid){
        return dao.findByOid(oid);
    }

    public List<OrderInfo> getOrdersByUid(String uid){
        return dao.findByUid(uid);
    }

    public OrderInfo newOrder(OrderInfo order){
        return dao.save(order);
    }
}
