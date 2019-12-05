package service.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public interface OrderDao extends JpaRepository<OrderInfo, String> {
    OrderInfo findByOid(String oid);

    List<OrderInfo> findByUid(String uid);

    void deleteByOid(String oid);
}
