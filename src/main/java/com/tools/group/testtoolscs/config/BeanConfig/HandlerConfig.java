package com.tools.group.testtoolscs.config.BeanConfig;

import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/22 10:47
 */
@Configuration
public class HandlerConfig {

    @Bean
    public AdbHandler getAdbHandler() {
        return AdbHandlerFactory.createDecoratorHandler();
    }
}
