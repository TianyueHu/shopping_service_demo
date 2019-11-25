package service.dubbo.api.bean;

import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

public class ShoppingCart {


    private String sid;

    private String uid;

    private String pid;

    private long unitPrice;

    private long num;

    private Timestamp updateTimestamp;

    public ShoppingCart(){

    }

    public ShoppingCart(String sid, String uid, String pid, long unitPrice, long num, Timestamp updateTimestamp){
        this.sid = sid;
        this.pid = pid;
        this.uid = uid;
        this.unitPrice = unitPrice;
        this.num = num;
        this.updateTimestamp = updateTimestamp;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
