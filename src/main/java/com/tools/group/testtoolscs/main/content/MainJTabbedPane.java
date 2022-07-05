package com.tools.group.testtoolscs.main.content;

import com.tools.group.testtoolscs.main.content.android.AndroidPane;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/8 17:38
 */
@Controller
public class MainJTabbedPane extends AbstractJPanel {
    @Autowired
    private AndroidPane androidPane;
    @Autowired
    private JTabbedPane jTabbedPane;

    public void myInit() {
        super.myInit();
        this.setLayout(new GridLayout());
        jTabbedPane.add(androidPane.getName(), androidPane);
        this.add(jTabbedPane);
    }
}
