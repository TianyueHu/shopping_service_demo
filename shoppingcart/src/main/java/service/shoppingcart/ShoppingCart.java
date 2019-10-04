package service.shoppingcart;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Entity
@Table(name = "shoppingcart")
@DynamicUpdate
@DynamicInsert
public class ShoppingCart {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "sid", nullable = false)
    private String sid;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "pid", nullable = false)
    private String pid;

    @Column(name = "unitPrice", nullable = false)
    private long unitPrice;

    @Column(name = "num", nullable = false)
    private long num;

    @UpdateTimestamp
    @Column(name = "updateTimestamp")
    private Timestamp updateTimestamp;

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
