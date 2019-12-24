package service.user;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.dubbo.api.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public boolean deposit(String uid, long num){
        User user = userDao.findByUid(uid);
        if(num < 0){
            throw new RuntimeException("The amount can't be negative");
        }
        if(user.getBalance() + num < 0){
            throw new RuntimeException("OverflowException");
        }
        user.setBalance(user.getBalance() + num);
        userDao.save(user);
        return true;
    }


    @Override
    @Transactional
    public String checkAndDeductBalance(String uid, long balance) {
        User user = userDao.findByUid(uid);
        if(balance < 0){
            throw new RuntimeException("The amount can't be negative");
        }
        if (user.getBalance() - balance < 0){
            throw new RuntimeException("Balance is not enough");
        }
        user.setBalance(user.getBalance() - balance);
        userDao.save(user);
        return user.getAddress();
    }

    @Override
    @Transactional
    public boolean deleteUser(String uid) {
        userDao.deleteByUid(uid);
        return true;
    }

    @Transactional
    public long getBalance(String uid){
        User user = userDao.findByUid(uid);
        return user.getBalance();
    }

    @Override
    @Transactional
    public String register(String userName, String phone, String address) {
        User user = new User();
        user.setName(userName);
        user.setPhone(phone);
        user.setAddress(address);
        user.setBalance(0);
        return userDao.save(user).getUid();
    }

    @Override
    @Transactional
    public service.dubbo.api.bean.User getUser(String uid){
        User user = userDao.findByUid(uid);
        if(user != null){
            service.dubbo.api.bean.User findUser = new service.dubbo.api.bean.User();
            findUser.setUid(user.getUid());
            findUser.setBalance(user.getBalance());
            findUser.setAddress(user.getAddress());
            findUser.setPhone(user.getPhone());
            findUser.setName(user.getName());
            return findUser;
        }
        return null;
    }
}
