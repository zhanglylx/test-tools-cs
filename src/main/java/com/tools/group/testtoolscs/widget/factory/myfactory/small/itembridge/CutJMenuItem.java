package com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyItem;
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
public class CutJMenuItem extends AbstractJMenuItem implements MyItem, MyWindow {

    @Override
    public void myInit() {
        this.myJMenuItem.setText("cut");
        this.myJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextComponent jsTextComponent = ((JTextComponent) component.getComponent());
                boolean editable = jsTextComponent.isEditable();
                jsTextComponent.setEditable(true);
                jsTextComponent.cut();
                if (!editable) jsTextComponent.setEditable(editable);
            }
        });
    }
}
