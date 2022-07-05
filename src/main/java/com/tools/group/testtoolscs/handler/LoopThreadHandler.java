package com.tools.group.testtoolscs.handler;

import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 用于在窗口中执行循环任务和需要在窗口显示以后再执行并且需要防止任务多开
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/19 18:56
 */
@Component
@Scope("prototype")
public class LoopThreadHandler {
    //线程终止状态
    private volatile boolean termination = true;
    //    用于阻塞线程还没有停止时的状态
    private final Object terminationWait = new Object();

    private LoopRunnable runnable;

    private Window window;
    @Autowired
    private ExecutorService executorService;

    private final Task task = new Task();

    public LoopRunnable getRunnable() {
        return runnable;
    }

    public void setRunnable(LoopRunnable runnable) {
        this.runnable = runnable;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void start() {
        if (!this.window.isShowing() && this.termination) {
            this.executorService.execute(task);
            this.termination = false;
        }
    }

    public void stop() {
        this.termination = true;
        synchronized (this.terminationWait) {
            try {
                this.terminationWait.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            while (!termination) {
                if (!runnable.run()) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(LoopRunnable.FAIL_LOOG_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (terminationWait) {
                terminationWait.notifyAll();
            }
        }
    }
}
