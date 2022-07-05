package com.tools.group.testtoolscs.handler.adbhandler.decorator;

import com.sun.media.sound.SoftTuning;
import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.widget.MyText;

import java.util.List;
import java.util.function.Function;

/**
 * 拼接指定设备装饰器
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/24 10:38
 */
public class AdbDeviceDecorator extends AdbHandlerDecorator {
    protected AppConfig appConfig = StaticApplicationContext.getApplicationContext().getBean(AppConfig.class);

    public AdbDeviceDecorator(AdbHandler adbHandler) {
        super(adbHandler);
    }

    @Override
    public List<String> execute(AdbCode adbCode) {
        setDevice(adbCode);
        return super.execute(adbCode);
    }

    public void setDevice(AdbCode adbCode) {
        String code = adbCode.getResult().toLowerCase();
//        todo 设置机型设备
        String device = adbCode.separator() + "-s" + adbCode.separator() + "ssffdfd" + adbCode.separator();
        if (code.startsWith(appConfig.getAdbExe().toLowerCase())) {
            adbCode.insert(
                    appConfig.getAdbExe().length()
                    , device);
        } else if (code.startsWith("adb")) {
            adbCode.insert(2, device);
        } else {
            throw new IllegalArgumentException("设置机型设备失败:" + adbCode);
        }
    }


}
