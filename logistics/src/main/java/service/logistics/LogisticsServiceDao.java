package service.logistics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public interface LogisticsServiceDao extends JpaRepository<LogisticsInfo, String> {

    LogisticsInfo findByLid(String Lid);

    LogisticsInfo findByOid(String Oid);
}
