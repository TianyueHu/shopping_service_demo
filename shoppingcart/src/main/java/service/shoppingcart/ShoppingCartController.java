package service.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ShoppingCart getCartsBySid(@RequestParam("sid") String sid){
        return service.getShoppingCart(sid);
    }

}
