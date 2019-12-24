package service.user;

import com.alibaba.druid.pool.DruidDataSource;
import essence.config.RMConfig;
import essence.rm.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
//@Import(RMConfig.class)
//@ComponentScan({"service.user", "essence.*"})
public class UserServiceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
    //public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    @Primary
    @Bean("dataSource")
    public DataSource dataSource(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

}
