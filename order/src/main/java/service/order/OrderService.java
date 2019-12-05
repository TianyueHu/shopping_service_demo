package service.order;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public String newOrder(String uid, String pid, long num, long totalPrices) {
        OrderInfo order = new OrderInfo();
        order.setUid(uid);
        order.setPid(pid);
        order.setNum(num);
        order.setTotalPrice(totalPrices);
        order.setStatus("NEW");
        return dao.save(order).getOid();
    }

    @Override
    @Transactional
    public service.dubbo.api.bean.OrderInfo orderCancel(String oid) {
        OrderInfo order = dao.findByOid(oid);
        service.dubbo.api.bean.OrderInfo origin = new service.dubbo.api.bean.OrderInfo(
                order.getOid(),
                order.getUid(),
                order.getPid(),
                order.getNum(),
                order.getStatus(),
                order.getTotalPrice(),
                order.getCreateTimestamp());
        order.setStatus("CANCEL");
        dao.save(order);

        return origin;
    }

    @Override
    @Transactional
    public boolean updateOrderStatus(String oid, String status) {
        OrderInfo orderInfo = dao.findByOid(oid);
        orderInfo.setStatus(status);
        dao.save(orderInfo);
        return false;
    }

    @Override
    @Transactional
    public service.dubbo.api.bean.OrderInfo getOrder(String oid) {
        OrderInfo order = dao.findByOid(oid);
        service.dubbo.api.bean.OrderInfo info = new service.dubbo.api.bean.OrderInfo(
                order.getOid(), order.getUid(), order.getPid(), order.getNum(),
                order.getStatus(), order.getTotalPrice(), order.getCreateTimestamp());
        return info;
    }

    @Override
    @Transactional
    public boolean deleteOrder(String oid) {
        dao.deleteByOid(oid);
        return true;
    }
}
