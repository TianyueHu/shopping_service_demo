package service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
public class LogisticsServiceController {

    @Autowired
    private LogisticsService service;

    @PostMapping("/newLogistics")
    public LogisticsInfo newLogistics(@RequestBody LogisticsInfo logistics){
        return service.newLogistics(logistics);
    }

    @GetMapping("/getAllLogisticsByUid")
    public List<LogisticsInfo> getAllLogisticsByUid(@RequestParam("uid") String uid){
        return service.getAllLogisticsByUid(uid);
    }
}
