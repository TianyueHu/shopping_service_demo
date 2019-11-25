package service.logistics;

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
@Table(name = "logistics")
@DynamicUpdate
@DynamicInsert
public class LogisticsInfo {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "lid", nullable = false, length = 128)
    private String lid;

    @Column(name = "oid", nullable = false, length = 128)
    private String oid;

    @Column(name = "status", nullable = false, length = 32)
    private String status;

    @UpdateTimestamp
    @Column(name = "createTimeStamp")
    private Timestamp createTimestamp;

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
