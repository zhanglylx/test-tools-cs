package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 14:49
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class MyJTabbedPane extends JTabbedPane implements MyWindow {
    @Autowired
    protected AppConfig appConfig;

    @PostConstruct
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT);
        this.setTabPlacement(JTabbedPane.LEFT);
    }

}
