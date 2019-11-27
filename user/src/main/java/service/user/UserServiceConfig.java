package service.user;

import com.alibaba.druid.pool.DruidDataSource;
import essence.bean.ConflictRelationship;
import essence.handler.TxStatusHandler;
import essence.rm.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class UserServiceConfig {
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
