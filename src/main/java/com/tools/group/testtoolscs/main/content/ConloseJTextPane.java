package com.tools.group.testtoolscs.main.content;

import com.tools.group.testtoolscs.widget.factory.AbstractJTextPane;
import com.tools.group.testtoolscs.widget.factory.listener.MyMouseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 10:45
 */
@Component
public class ConloseJTextPane extends AbstractJTextPane implements MyMouseListener {
    @Autowired
    private JPopupMenu jsPopupMenu;

    @Autowired
    private JMenuItem clearMenu;

    @Override
    public void myInit() {
        super.myInit();
        this.setToolTipText("这里是输出台");
        this.clearMenu.setText("clear");
        this.clearMenu.addActionListener(e -> clear());
        jsPopupMenu.add(clearMenu);
//        this.add(jsPopupMenu);
//        this.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            jsPopupMenu.show(this, e.getX(), e.getY());
        }
    }

}
