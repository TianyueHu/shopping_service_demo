package service.logistics;

import com.alibaba.druid.pool.DruidDataSource;
import essence.rm.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */

@Configuration
public class LogisticsServiceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }


    @Primary
    @Bean("dataSource")
    public DataSource dataSource(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

}
