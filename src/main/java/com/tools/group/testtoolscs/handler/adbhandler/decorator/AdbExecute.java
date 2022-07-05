package com.tools.group.testtoolscs.handler.adbhandler.decorator;

import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.common.utils.adb.AdbUtils;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.widget.MyText;

import java.util.List;
import java.util.function.Function;

/**
 * 执行adb命令
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/24 10:54
 */
public class AdbExecute implements AdbHandler {
    @Override
    public List<String> execute(AdbCode adbCode) {
        return AdbUtils.execute(adbCode);
    }
}
