package service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zheting Hu
 * @date 2019-10-02
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(OrderApplication.class)
//                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
//                    Environment environment = event.getEnvironment();
//                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
//                    new EmbeddedZooKeeper(port, false).start();
//                })
//                .run(args);
        SpringApplication.run(OrderApplication.class);
    }
}
