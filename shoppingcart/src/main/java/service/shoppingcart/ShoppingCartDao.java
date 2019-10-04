package service.shoppingcart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, String> {

    List<ShoppingCart> findByUid(String uid);

    void deleteByUidAndPid(String uid, String pid);

    List<ShoppingCart> findByUidAndPid(String uid, String pid);

    ShoppingCart findBySid(String sid);
}
