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

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductDao dao;

    @Override
    @Transactional
    public service.dubbo.api.bean.Product getProduct(String pid){
        Product product = dao.findByPid(pid);
        return new service.dubbo.api.bean.Product(
                product.getPid(),
                product.getpName(),
                product.getDescription(),
                product.getUnitPrice(),
                product.getInventory(),
                product.getUpdateTimestamp());
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
    public boolean replenishStock(String pid, long num) {
        Product product = dao.findByPid(pid);
        if (num > 0 && product.getInventory() + num > 0){
            product.setInventory(product.getInventory() + num);
            dao.save(product);
        }

        return true;
    }

    @Override
    public String newProduct(service.dubbo.api.bean.Product product) {
        Product product1 = new Product();
        product1.setDescription(product.getDescription());
        product1.setInventory(product.getInventory());
        product1.setpName(product.getpName());
        product1.setUnitPrice(product.getUnitPrice());
        product1.setUpdateTimestamp(product.getUpdateTimestamp());
        return dao.save(product1).getPid();
    }
}
