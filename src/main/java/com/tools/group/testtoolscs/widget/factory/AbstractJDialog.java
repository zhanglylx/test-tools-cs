package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/11 10:48
 */
public class AbstractJDialog extends JDialog implements MyWindow {

    @Autowired
    protected AppConfig appConfig;

    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                ,InitThemeStrategy.InitThemeType.FONT
                ,InitThemeStrategy.InitThemeType.ICON);
    }
}
