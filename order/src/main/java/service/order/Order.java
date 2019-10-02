package service.order;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public class Order {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "oid", nullable = false, length = 128)
    private String oid;

    @Column(name = "uid", nullable = false, length = 128)
    private String uid;

    @Column(name = "pid", nullable = false, length = 128)
    private String pid;

    @Column(name = "unitPrice", nullable = false)
    private long unitPrice;

    @Column(name = "totalPrices", nullable = false)
    private long totalPrices;

    @CreationTimestamp
    @Column(name = "timestamp")
    private Timestamp timestamp;

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

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(long totalPrices) {
        this.totalPrices = totalPrices;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
