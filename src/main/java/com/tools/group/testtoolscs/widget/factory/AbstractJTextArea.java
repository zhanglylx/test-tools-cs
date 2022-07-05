package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge.MouseRightJMenuBridge;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 17:51
 */
public abstract class AbstractJTextArea extends JTextArea implements MyWindow {
    @Autowired
    protected AppConfig appConfig;
    @Autowired
    MouseRightJMenuBridge mouseRightJMenuBridge;

    @PostConstruct
    @Override
    public void myInit() {
        this.setLineWrap(true);
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT
                , InitThemeStrategy.InitThemeType.MARGIN);
        mouseRightJMenuBridge.relevance(this);
    }

    public void append(List<?> list) {
        list.forEach(o1 -> append(o1.toString()));
    }

    @Override
    public void append(String str) {
        this.append(str, true);
    }

    public void append(String str, boolean isLine) {
        super.append(str);
        if (isLine) super.append("\n");
        this.setCaretPosition(this.getText().length());
    }

}
