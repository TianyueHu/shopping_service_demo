package service.logistics;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.dubbo.api.LogisticsServiceInterface;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Service
public class LogisticsService implements LogisticsServiceInterface {

    @Autowired
    private LogisticsServiceDao dao;

    public LogisticsInfo newLogistics(LogisticsInfo logistics){
        return dao.save(logistics);
    }

    @Override
    @Transactional
    public String newLogistics(String oid) {
        LogisticsInfo info = new LogisticsInfo();
        info.setOid(oid);
        info.setStatus("NEW");
        info = dao.save(info);
        return info.getLid();
    }

    @Override
    @Transactional
    public String updateLogisticsStatus(String oid, String status) {
        LogisticsInfo info = dao.findByOid(oid);
        String origin = info.getStatus();
        info.setStatus(status);
        dao.save(info);
        return origin;
    }
}
