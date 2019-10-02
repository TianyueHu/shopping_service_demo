package service.logistics;

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
public class Logistics {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "lid", nullable = false, length = 128)
    private String lid;

    @Column(name = "oid", nullable = false, length = 128)
    private String oid;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Column(name = "status", nullable = false, length = 32)
    private String status;

    @UpdateTimestamp
    @Column(name = "updateTimeStamp")
    private Timestamp updateTimestamp;

    public String getLid() {
        return lid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
