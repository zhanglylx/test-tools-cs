package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/11 11:21
 */
@Component
@Scope("prototype")
public class MyJScrollPane extends JScrollPane implements MyWindow {

    @PostConstruct
    @Override
    public void myInit() {

        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                ,InitThemeStrategy.InitThemeType.FONT);
    }
}
