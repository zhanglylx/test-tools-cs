package com.tools.group.testtoolscs.main.content.android;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/8 17:50
 */
@Component
public class AndroidPane extends AbstractJPanel implements MyWindow {
    @Autowired
    private JTabbedPane jTabbedPane;

    @Autowired
    private InstallApk installApk;
    @Autowired
    private GrabScreen grabScreen;

    @PostConstruct
    @Override
    public void myInit() {
        super.myInit();
        this.setLayout(new BorderLayout());
        this.setName("android");
        this.jTabbedPane.add(installApk.getName(),installApk);
        this.jTabbedPane.add(grabScreen.getName(),grabScreen);
        this.add(this.jTabbedPane);
    }
}
