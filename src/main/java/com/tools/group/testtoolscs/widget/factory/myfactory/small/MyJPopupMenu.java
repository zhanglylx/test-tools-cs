package com.tools.group.testtoolscs.widget.factory.myfactory.small;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 普通的菜单
 * @author zly
 * @version 1.0
 * @date 2021/2/10 14:34
 */
@Component
@Scope("prototype")
public class MyJPopupMenu extends JPopupMenu implements MyWindow {

    @Autowired
    protected AppConfig appConfig;

    @PostConstruct
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.FONT
                ,InitThemeStrategy.InitThemeType.BACKGROUND);;
    }
}
