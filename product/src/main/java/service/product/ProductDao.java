package service.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public interface ProductDao extends JpaRepository<Product, String> {

    Product findByPid(String pid);

}
