package service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/newOrder")
    public OrderInfo newOrder(@RequestBody OrderInfo order){
        if(order.getTotalPrices() <= 0){
            order.setTotalPrices(order.getUnitPrice() * order.getNum());
        }
        return orderService.newOrder(order);
    }
}
