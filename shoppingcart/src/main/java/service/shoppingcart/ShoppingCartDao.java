package service.shoppingcart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, String> {

    public List<ShoppingCart> findByUid(String uid);

    public void deleteByUidAndPid(String uid, String pid);

    public List<ShoppingCart> findByUidAndPid(String uid, String pid);

    public ShoppingCart findBySid(String sid);
}
