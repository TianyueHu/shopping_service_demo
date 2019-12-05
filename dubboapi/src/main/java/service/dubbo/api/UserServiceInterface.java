package service.dubbo.api;

import service.dubbo.api.bean.User;

/**
 * @author Zheting Hu
 * @date 2019-11-23
 */
public interface UserServiceInterface {

    /*
    output: uid
     */
    public String register(String userName, String phone, String address);

    /*
    output: if deposit success
     */
    public boolean deposit(String uid, long balance);

    public User getUser(String uid);

    public String checkAndDeductBalance(String uid, long balance);
}
