package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge.MouseRightJMenuBridge;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 12:11
 */
@Component
@Scope("prototype")
public class MyJTextField extends JTextField implements MyWindow {

    @Autowired
    MouseRightJMenuBridge mouseRightJMenuBridge;

    @PostConstruct
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT
                , InitThemeStrategy.InitThemeType.MARGIN);
        mouseRightJMenuBridge.relevance(this);
    }
}
