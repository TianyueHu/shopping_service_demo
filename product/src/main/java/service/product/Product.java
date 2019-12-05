package service.product;

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
@Table(name = "product")
@DynamicUpdate
@DynamicInsert
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
    private long inventory;

    @UpdateTimestamp
    @Column(name = "updateTimestamp")
    private Timestamp updateTimestamp;

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

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
