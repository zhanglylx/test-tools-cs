package com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyComponent;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyItem;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.MyJMenuItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/12 12:33
 */
public abstract class AbstractJMenuItem implements MyItem, MyWindow {
    @Autowired
    protected MyJMenuItem myJMenuItem;

    protected MyComponent component;

    @Override
    public JMenuItem getMenuItem() {
        return myJMenuItem;
    }

    @Override
    public void setComponent(MyComponent c) {
        this.component = c;
    }
}
