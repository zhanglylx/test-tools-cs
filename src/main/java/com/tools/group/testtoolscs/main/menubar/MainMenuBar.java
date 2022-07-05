package com.tools.group.testtoolscs.main.menubar;

import com.tools.group.testtoolscs.widget.MyWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/5 10:10
 */
@Component
public class MainMenuBar extends JMenuBar implements MyWindow {
    private JMenu help = new JMenu("Help");
    private JMenuItem about = new JMenuItem("About");
    @Autowired
    private AboutDialog aboutDialog;

    @PostConstruct
    public void myInit() {
        initHelp();
        initAbout();
    }

    private void initAbout() {
        this.about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                aboutDialog.setVisible(true);
            }
        });
    }

    private void initHelp() {
        this.add(help);
        this.help.add(about);
    }
}
