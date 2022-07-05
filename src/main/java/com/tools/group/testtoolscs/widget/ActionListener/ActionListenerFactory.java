package com.tools.group.testtoolscs.widget.ActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/4 14:42
 */
public interface ActionListenerFactory {
    ActionListener getOpenJFrame(Class<? extends JFrame> clazz);
}
