package service.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class ShoppingService {

    @Autowired
    private ShoppingCartDao dao;

    public ShoppingCart getShoppingCart(String sid){
        ShoppingCart sc = dao.findBySid(sid);
        if (sc == null){
            throw new RuntimeException("");
        }
        return sc;
    }

    public List<ShoppingCart> getCarts(String uid){
        return dao.findByUid(uid);
    }

    public List<ShoppingCart> getCarts(String uid, String pid){
        return dao.findByUidAndPid(uid, pid);
    }

    public ShoppingCart updateCart(ShoppingCart sc){
        ShoppingCart ssc = dao.findBySid(sc.getSid());
        if (ssc == null){
            return dao.save(sc);
        }
        ssc.setNum(ssc.getNum() + sc.getNum());
        return dao.save(ssc);
    }
}
