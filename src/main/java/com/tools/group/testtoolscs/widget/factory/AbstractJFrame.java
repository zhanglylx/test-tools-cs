package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/4 9:50
 */

public abstract class AbstractJFrame extends JFrame implements MyWindow {
    @Autowired
    protected ImageConfig imageConfig;

    @Autowired
    protected AppConfig appConfig;

    @PostConstruct
    @Override
    public void myInit() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(close(e));
            }
        });
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT
                , InitThemeStrategy.InitThemeType.ICON);
    }


    public int close(WindowEvent e) {
        return WindowConstants.DISPOSE_ON_CLOSE;
    }

    static {
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green");
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
