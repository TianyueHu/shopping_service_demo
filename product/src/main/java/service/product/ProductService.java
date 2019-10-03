package service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;

    public Product getProduct(String pid){
        return dao.findByPid(pid);
    }

    public Product updateProduct(Product product){
        return dao.save(product);
    }
}
