package com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge;

import com.tools.group.testtoolscs.widget.factory.listener.MyMouseListener;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyComponent;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyItem;
import org.springframework.stereotype.Component;

import java.awt.event.MouseEvent;

/**
 * 使用桥接模式，将组件与弹出菜单相关联
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/12 12:22
 */
@Component
@SuppressWarnings("unchecked")
public class MouseRightJMenuBridge extends AbstractJMenuBridge implements MyMouseListener, MyComponent {


    public final void relevance(java.awt.Container relevance,
                                Class<? extends MyItem>... myItems) {
        super.relevance(relevance, myItems);
        relevance.addMouseListener(this);
    }

    public void relevance(java.awt.Container relevance) {
        relevance(relevance
                , ClearJMenuItem.class
                , CopyJMenuItem.class
                , CutJMenuItem.class);
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            component = e.getComponent();
            this.myPopupMenu.show(component, e.getX(), e.getY());
        }
    }

}
