package com.tools.group.testtoolscs.handler.adbhandler.decorator;

import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.widget.MyText;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 在windows机型下拼接adb绝对路径
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/24 10:02
 */
public class AdbEnvironmentDecorator extends AdbHandlerDecorator {
    protected AppConfig appConfig = StaticApplicationContext.getApplicationContext().getBean(AppConfig.class);

    public AdbEnvironmentDecorator(AdbHandler adbHandler) {
        super(adbHandler);
    }

    @Override
    public List<String> execute(AdbCode adbCode) {
        formatHandler(adbCode);
        return super.execute(adbCode);
    }

    /**
     * 格式化AdbCode,将adb命令指向系统中adb的绝对路径位置
     *
     * @param adbCode
     * @return
     */
    public void formatHandler(AdbCode adbCode) {
        String[] adb = new String[]{"a", "d", "b"};
//        todo 这里应区分系统，windows系统执行以下操作
        if (Arrays.equals(adb, adbCode.get(0, 3))) adbCode.remove(0, 3);
        adbCode.insert(0, appConfig.getAdbExe());
    }
}
