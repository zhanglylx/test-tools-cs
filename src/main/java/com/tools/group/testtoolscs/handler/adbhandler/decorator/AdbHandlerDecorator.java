package com.tools.group.testtoolscs.handler.adbhandler.decorator;

import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.widget.MyText;

import java.util.List;
import java.util.function.Function;

/**
 * adb处理器装饰器
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/24 10:07
 */
public class AdbHandlerDecorator implements AdbHandler {
    private final AdbHandler adbHandler;

    public AdbHandlerDecorator(AdbHandler adbHandler) {
        this.adbHandler = adbHandler;
    }

    @Override
    public List<String> execute(AdbCode adbCode) {
        return this.adbHandler.execute(adbCode);
    }
}
