package service.shoppingcart;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.dubbo.api.ShoppingCartServiceInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class ShoppingService implements ShoppingCartServiceInterface {
    Logger LOG = LoggerFactory.getLogger(ShoppingService.class);

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

    @Override
    @Transactional
    public List<service.dubbo.api.bean.ShoppingCart> getShoppingCartItems(String uid) {
        List<ShoppingCart> list = dao.findByUid(uid);
        List<service.dubbo.api.bean.ShoppingCart> sidList = new ArrayList<>();

        if(list != null){
            for(ShoppingCart sc : list){
                sidList.add(ScTransformer.transfrom(sc));
            }
        }
        return sidList;
    }

    @Override
    @Transactional
    public boolean addProductToShopppingCart(String uid, service.dubbo.api.bean.Product product, long num) {
        if(product == null || product.getPid() == null){
            LOG.error("pid cannot be null");
            throw new RuntimeException("pid cannot be null");
        }

        List<ShoppingCart> scs = dao.findByUidAndPid(uid, product.getPid());
        if(scs != null && scs.size() > 0){
            ShoppingCart sc = scs.get(0);
            if(sc.getNum() + num > 0){
                sc.setNum(num + sc.getNum());
                dao.save(sc);
            }
            else if(sc.getNum() + num == 0){
                dao.delete(sc);
            }
            else{
                LOG.error("The quantity of goods in the shopping cart cannot be less than 0");
                throw new RuntimeException("The quantity of goods in the shopping cart cannot be less than 0");
            }
        }
        else{
            ShoppingCart sc = new ShoppingCart();
            sc.setNum(num);
            sc.setUid(uid);
        }

        return true;
    }

    @Override
    @Transactional
    public boolean deleteProductInShopppingCart(String uid, String pid) {
        dao.deleteByUidAndPid(uid, pid);
        return true;
    }
}
