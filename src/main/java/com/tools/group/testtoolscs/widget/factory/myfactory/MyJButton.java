package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 13:59
 */
@Component
@Scope("prototype")
public class MyJButton extends JButton implements MyWindow {
    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    @Override
    public void myInit() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.FONT
                , InitThemeStrategy.InitThemeType.HAND_CURSOR);
    }
}
