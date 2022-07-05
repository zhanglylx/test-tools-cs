package com.tools.group.testtoolscs.main.menubar;

import com.tools.group.testtoolscs.widget.MyWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * 关于面板
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/5 11:44
 */
@Component
public class AboutDialog extends JDialog implements MyWindow {

    @Autowired
    private JTabbedPane jTabtoPathPane;
    @Autowired
    private AboutLogoPanel aboutLogoJPanel;

    public AboutDialog(@Qualifier("main") Frame owner) {
        super(owner, true);
        this.setTitle("About");
    }

    @PostConstruct
    @Override
    public void myInit() {
        jTabtoPathPane.add(aboutLogoJPanel.getName(), aboutLogoJPanel);
        this.jTabtoPathPane.setTabPlacement(JTabbedPane.TOP);
        this.setContentPane(jTabtoPathPane);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dlgSize = new Dimension(720, 570);
        int dlgPosX = (screenSize.width / 2) - (dlgSize.width / 2);
        int dlgPosY = (screenSize.height / 2) - (dlgSize.height / 2);
        setSize(dlgSize);
        setLocation(dlgPosX, dlgPosY);
    }

}
