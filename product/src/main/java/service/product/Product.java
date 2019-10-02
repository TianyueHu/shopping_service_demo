package service.product;

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
public class Product {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "pid", nullable = false, length = 128)
    private String pid;

    @Column(name = "pName", nullable = false, length = 64)
    private String pName;

    @Column(name = "description", nullable = false, length = 128)
    private String description;

    @Column(name = "unitPrice", nullable = false)
    private long unitPrice;

    @Column(name = "inventory", nullable = false)
    private int inventory;

    @UpdateTimestamp
    @Column(name = "updateTimeStamp")
    private Timestamp updateTimeStamp;

    public String getPid(){
        return pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Timestamp getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Timestamp updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
