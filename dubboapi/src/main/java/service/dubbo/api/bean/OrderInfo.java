package service.dubbo.api.bean;

import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

public class OrderInfo {

    private String oid;

    private String uid;

    private String pid;

    private long num;

    private String status;

    private long totalPrice;

    private Timestamp createTimestamp;

    public OrderInfo(){

    }

    public OrderInfo(String oid, String uid, String pid,
                     long num, String status,
                     long totalPrice, Timestamp createTimestamp){
        this.oid = oid;
        this.num = num;
        this.uid = uid;
        this.pid = pid;
        this.status = status;
        this.createTimestamp = createTimestamp;
        this.totalPrice = totalPrice;
    }

    public void setOid(String oid){
        this.oid = oid;
    }

    public String getOid() {
        return oid;
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

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrices) {
        this.totalPrice = totalPrices;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
