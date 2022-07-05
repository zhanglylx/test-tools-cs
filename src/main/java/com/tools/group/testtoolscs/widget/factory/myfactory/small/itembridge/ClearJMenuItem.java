package com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge;

import org.springframework.stereotype.Component;

import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/12 12:13
 */
@Component
public class ClearJMenuItem extends AbstractJMenuItem {

    @Override
    public void myInit() {
        this.myJMenuItem.setText("clear");
        this.myJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JTextComponent) component.getComponent()).setText("");
            }
        });
    }

}
