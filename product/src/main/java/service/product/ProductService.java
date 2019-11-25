package service.product;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.dubbo.api.ProductServiceInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service(version = "1.0.0")
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductDao dao;

    public Product getProduct(String pid){
        return dao.findByPid(pid);
    }

    public Product updateProduct(Product product){
        return dao.save(product);
    }


    @Override
    @Transactional
    public List<service.dubbo.api.bean.Product> getAllProduct() {
        List<Product> products = dao.findAll();
        List<service.dubbo.api.bean.Product> ret = new ArrayList<>();
        products.forEach(
                product -> ret.add(
                        new service.dubbo.api.bean.Product(
                                product.getPid(),
                                product.getpName(),
                                product.getDescription(),
                                product.getUnitPrice(),
                                product.getInventory(),
                                product.getUpdateTimestamp())));
        return ret;
    }

    @Override
    @Transactional
    public boolean checkAndDetuctInventory(String pid, int num) {
        Product product = dao.findByPid(pid);
        if (num > 0 && product.getInventory() >= num){
            product.setInventory(product.getInventory() - num);
            dao.save(product);
        }
        else{
            throw new RuntimeException("Insufficient inventory");
        }
        return true;
    }

    @Override
    @Transactional
    public boolean replenishStock(String pid, int num) {
        Product product = dao.findByPid(pid);
        if (num > 0 && product.getInventory() + num > 0){
            product.setInventory(product.getInventory() + num);
            dao.save(product);
        }

        return true;
    }
}
