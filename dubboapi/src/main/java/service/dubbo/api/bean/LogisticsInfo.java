package service.dubbo.api.bean;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public class LogisticsInfo implements Serializable {

    private static final long serialVersionUID = 4567896989L;

    private String lid;

    private String oid;

    private String status;

    private Timestamp createTimestamp;

    public LogisticsInfo(){

    }

    public LogisticsInfo(String lid, String oid, String status, Timestamp timestamp){
        this.lid = lid;
        this.oid = oid;
        this.status = status;
        this.createTimestamp = timestamp;
    }

    public void setLid(String lid){
        this.lid = lid;
    }

    public String getLid() {
        return lid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
