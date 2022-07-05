package com.tools.group.testtoolscs.widget;

import com.tools.group.testtoolscs.common.utils.ZLYDateUtils;
import org.springframework.stereotype.Component;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/18 17:03
 */
@Component
public class SystemOutPrintText implements MyText {
    @Override
    public void addText(String text) {
        System.out.println(ZLYDateUtils.getStrSysSpecifiedFormat("HH:mm:ss  ") + text);
    }

    @Override
    public void addErrMessage(String text) {
        System.out.println(ZLYDateUtils.getStrSysSpecifiedFormat("HH:mm:ss  ") + text);
    }

    @Override
    public void addSucMessage(String text) {
        System.out.println(ZLYDateUtils.getStrSysSpecifiedFormat("HH:mm:ss  ") + text);
    }

    @Override
    public void clear() {

    }

    @Override
    public void addException(Exception e) {
        e.printStackTrace();
    }
}
