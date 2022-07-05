package com.tools.group.testtoolscs.handler;

import java.util.concurrent.TimeUnit;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/20 17:37
 */
public interface LoopRunnable {

    long FAIL_LOOG_TIME = TimeUnit.MILLISECONDS.toMillis(1000);

    /**
     * 执行成功的结果
     *
     * @return 如果为false，为每失败后延时1000毫秒后执行
     */
    boolean run();
}
