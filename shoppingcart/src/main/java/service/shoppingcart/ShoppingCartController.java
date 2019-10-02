package service.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingService service;

    @PostMapping("/updateCart")
    public ShoppingCart updateCart(@RequestBody ShoppingCart sc){
        return service.updateCart(sc);
    }

    @GetMapping("/getCartsBySid")
    public ShoppingCart getCartsBySid(String sid){
        return service.getShoppingCart(sid);
    }

}
