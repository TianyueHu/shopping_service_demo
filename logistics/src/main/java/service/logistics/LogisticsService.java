package service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class LogisticsService {

    @Autowired
    private LogisticsServiceDao dao;

    public LogisticsInfo newLogistics(LogisticsInfo logistics){
        return dao.save(logistics);
    }

    public List<LogisticsInfo> getAllLogisticsByUid(String oid){
        return dao.findByOid(oid);
    }
}
