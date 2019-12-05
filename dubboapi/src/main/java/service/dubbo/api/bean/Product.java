package service.dubbo.api.bean;

import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

public class Product {

    private String pid;

    private String pName;

    private String description;

    private long unitPrice;

    private long inventory;

    private Timestamp updateTimestamp;

    public Product(){

    }

    public Product(String pid, String pName, String description, long unitPrice, long inventory, Timestamp updateTimestamp){
        this.pid = pid;
        this.pName = pName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.updateTimestamp = updateTimestamp;
    }

    public void setPid(String pid){
        this.pid = pid;
    }

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
