package service.dubbo.api;

/**
 * @author Zheting Hu
 * @date 2019-11-25
 */
public interface LogisticsServiceInterface {

    public String newLogistics(String oid);

    public String updateLogisticsStatus(String oid, String status);

}
