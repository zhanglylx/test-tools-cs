package com.tools.group.testtoolscs.widget.ActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/4 14:44
 */
public class ActionListenerFactoryImpl implements ActionListenerFactory {

    @Override
    public ActionListener getOpenJFrame(Class<? extends JFrame> clazz) {
        return new OpenFrameActionListener(clazz);
    }
}
