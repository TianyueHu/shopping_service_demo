package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User debit(String uid, long num){
        User user = userDao.findByUid(uid);
        if(num < 0){
            throw new RuntimeException("The amount can't be negative");
        }
        user.setBalance(user.getBalance() - num);
        return userDao.save(user);
    }

    public User deposit(String uid, long num){
        User user = userDao.findByUid(uid);
        if(num < 0){
            throw new RuntimeException("The amount can't be negative");
        }
        user.setBalance(user.getBalance() + num);
        return userDao.save(user);
    }

    public long getBalance(String uid){
        User user = userDao.findByUid(uid);
        return user.getBalance();
    }

    public User getUser(String uid){
        return userDao.findByUid(uid);
    }

    public User newUser(User user){
        return userDao.save(user);
    }
}
