package com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge;

import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyComponent;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyItem;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyJPopupMenu;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 弹出菜单桥，这个桥可以将组建和已经存在的菜单类型桥进行关联
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/12 12:52
 */
@Data
@SuppressWarnings("unchecked")
public abstract class AbstractJMenuBridge implements MyComponent {

    @Autowired
    protected MyJPopupMenu myPopupMenu;

    protected java.awt.Component component;

    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    public java.awt.Component getComponent() {
        return component;
    }

    public void relevance(java.awt.Container relevance,
                          Class<? extends MyItem>... myItems) {
        for (Class<? extends MyItem> myItem : myItems) {
            MyItem m = applicationContext.getBean(myItem);
            this.myPopupMenu.add(applicationContext.getBean(myItem).getMenuItem());
            m.setComponent(this);
        }
        relevance.add(this.myPopupMenu);
    }



}
