package service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/updateProduct")
    public Product newProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
