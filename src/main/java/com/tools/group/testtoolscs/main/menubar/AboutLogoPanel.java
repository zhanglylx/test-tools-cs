package com.tools.group.testtoolscs.main.menubar;

import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import com.tools.group.testtoolscs.widget.factory.template.MyImageSliderPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 15:37
 */
@Component
public class AboutLogoPanel extends AbstractJPanel {

    @Autowired
    private LogoPanel startFigurePanel;

    @Override
    public void myInit() {
        super.myInit();
        this.setName("About");
        this.add(startFigurePanel, BorderLayout.CENTER);


    }
}
