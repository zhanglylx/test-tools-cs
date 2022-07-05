package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * 单纯的显示文本
 * @author zly
 * @version 1.0
 * @date 2021/2/19 17:15
 */
@Component
@Scope("prototype")
public class MyJLabel extends JLabel implements MyWindow {
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT);
    }
}
