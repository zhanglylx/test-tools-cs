package com.tools.group.testtoolscs.widget.factory.theme;

import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/11 22:19
 */
public class MarginInitTheme implements MyTheme {
    @Override
    public void initTheme(Component o) {
        ((JTextComponent) (o)).setMargin(new Insets(0, 3, 0, 0));

    }
}
