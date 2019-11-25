package service.order;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.dubbo.api.OrderServiceInterface;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class OrderService implements OrderServiceInterface {

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

    @Override
    public String newOrder(String uid, String pid, long num, long totalPrices) {
        OrderInfo order = new OrderInfo();
        order.setUid(uid);
        order.setPid(pid);
        order.setNum(num);
        order.setTotalPrices(totalPrices);
        order.setStatus("NEW");
        return dao.save(order).getOid();
    }

    @Override
    public boolean orderCancel(String oid) {
        OrderInfo order = dao.findByOid(oid);
        if(order.getStatus().equals("NEW")){
            order.setStatus("CANCEL");
            dao.save(order);
        }
        return false;
    }

    @Override
    public boolean updateOrderStatus(String oid, String status) {
        return false;
    }

    @Override
    public service.dubbo.api.bean.OrderInfo getOrder(String oid) {
        OrderInfo order = dao.findByOid(oid);
        service.dubbo.api.bean.OrderInfo info = new service.dubbo.api.bean.OrderInfo(
                order.getOid(), order.getUid(), order.getPid(), order.getNum(),
                order.getStatus(),order.getTotalPrices(), order.getCreateTimestamp());
        return info;
    }
}
