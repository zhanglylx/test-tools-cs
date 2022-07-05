package com.tools.group.testtoolscs.config.BeanConfig;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/19 18:16
 */
@Configuration
public class ThreadConfig {
    @Bean(value = "csQueueThreadPool")
    public ExecutorService buildCoinQueueThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("user-coin-queue-thread-%d").build();
        // 实例化线程池
        return new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(300), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
