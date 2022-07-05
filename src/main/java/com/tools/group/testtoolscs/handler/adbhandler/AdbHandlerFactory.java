package com.tools.group.testtoolscs.handler.adbhandler;

import com.tools.group.testtoolscs.handler.adbhandler.decorator.AdbDeviceDecorator;
import com.tools.group.testtoolscs.handler.adbhandler.decorator.AdbExecute;
import com.tools.group.testtoolscs.handler.adbhandler.decorator.AdbEnvironmentDecorator;

/**
 * adb处理器创建工厂
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/22 10:44
 */
public class AdbHandlerFactory {
    /**
     * 创建一个以装饰器模式的处理器
     *
     * @return 所有的adb装饰器
     */
    public static AdbHandler createDecoratorHandler() {
        AdbHandler adbHandler = new AdbExecute();
        adbHandler = new AdbDeviceDecorator(adbHandler);
        adbHandler = new AdbEnvironmentDecorator(adbHandler);
        return adbHandler;
    }
}
