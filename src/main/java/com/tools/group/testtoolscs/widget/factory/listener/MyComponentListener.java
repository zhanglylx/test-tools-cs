package com.tools.group.testtoolscs.widget.factory.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/19 12:44
 */
public interface MyComponentListener extends ComponentListener {
    @Override
    default void componentResized(ComponentEvent e) {
    }

    @Override
    default void componentMoved(ComponentEvent e) {
    }

    @Override
    default void componentShown(ComponentEvent e) {
    }

    @Override
    default void componentHidden(ComponentEvent e) {
    }
}
