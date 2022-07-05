package com.tools.group.testtoolscs.widget.factory.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 14:20
 */
public interface MyMouseListener extends MouseListener {
    @Override
   default void mouseClicked(MouseEvent e){}

    @Override
    default void mousePressed(MouseEvent e){}

    @Override
    default void mouseReleased(MouseEvent e){}

    @Override
    default void mouseEntered(MouseEvent e){}

    @Override
    default void mouseExited(MouseEvent e){}
}
