package com.tools.group.testtoolscs.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 用于在线程中执行任务并管控并在启动前限制控件和运行结束后释放控件
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/22 17:48
 */
@Slf4j
@Component
public class ControlLimitsThreadHandler {

    @Autowired
    private ExecutorService executorService;

    public void Handler(Runnable runnable, java.awt.Component... components) {
        executorService.execute(() -> {
            if (components != null)
                for (java.awt.Component c : components)
                    c.setEnabled(false);
            try {
                runnable.run();
            } catch (Exception e) {
                log.error("执行控件管控线程任务异常", e);
            } finally {
                if (components != null)
                    for (java.awt.Component c : components)
                        c.setEnabled(true);
            }
        });

    }

}
