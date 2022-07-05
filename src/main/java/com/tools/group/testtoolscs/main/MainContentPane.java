package com.tools.group.testtoolscs.main;

import com.tools.group.testtoolscs.main.content.ConloseJTextPane;
import com.tools.group.testtoolscs.main.content.MainJTabbedPane;
import com.tools.group.testtoolscs.main.menubar.MainToolBar;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 内容面板，此为主框架中的主要内容，相当于是一个桥
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/18 10:44
 */
@Component
public class MainContentPane extends AbstractJPanel {
    @Autowired
    private ConloseJTextPane conloseJTextPane;
    @Autowired
    private MainJTabbedPane mainTabbedPane;
    @Autowired
    private MainToolBar mainToolBar;

    @Override
    public void myInit() {
        super.myInit();
        this.setLayout(new BorderLayout());
        this.conloseJTextPane.setEditable(false);
        this.conloseJTextPane.add(new MainToolBar(), BorderLayout.NORTH);
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, this.mainTabbedPane, this.conloseJTextPane.getScrollPane());
        jSplitPane.setDividerLocation(450);
        this.add(mainToolBar, BorderLayout.NORTH);
        this.add(jSplitPane, BorderLayout.CENTER);
    }
}
