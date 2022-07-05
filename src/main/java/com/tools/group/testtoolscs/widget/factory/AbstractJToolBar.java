package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;

import javax.swing.*;
import java.io.IOException;

/**
 * 工具条
 * @author zly
 * @version 1.0
 * @date 2021/2/19 17:06
 */
public abstract class AbstractJToolBar extends JToolBar implements MyWindow {
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT
                );
    }
}
