package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.IOException;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 12:44
 */
public abstract class AbstractJPanel extends JPanel implements MyWindow {
    @Autowired
    protected AppConfig appConfig;

    @PostConstruct
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
        ,InitThemeStrategy.InitThemeType.FONT);
    }
}
