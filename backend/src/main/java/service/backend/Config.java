package service.backend;

import essence.config.RMConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Zheting Hu
 * @date 2019-11-27
 */

@Configuration
@Import(RMConfig.class)
public class Config {
}
