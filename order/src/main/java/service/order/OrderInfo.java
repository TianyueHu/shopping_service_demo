package service.order;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Entity
@Table(name = "orderinfo")
@DynamicUpdate
@DynamicInsert
public class OrderInfo {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "oid", nullable = false, length = 128)
    private String oid;

    @Column(name = "uid", nullable = false, length = 128)
    private String uid;

    @Column(name = "pid", nullable = false, length = 128)
    private String pid;

    @Column(name = "num", nullable = false)
    private long num;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "totalPrice", nullable = false)
    private long totalPrice;

    @CreationTimestamp
    @Column(name = "createTimestamp")
    private Timestamp createTimestamp;

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
