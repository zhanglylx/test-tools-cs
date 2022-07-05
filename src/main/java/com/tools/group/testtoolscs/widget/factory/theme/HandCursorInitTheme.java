package com.tools.group.testtoolscs.widget.factory.theme;

import java.awt.*;

/**
 * 设置鼠标手
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/11 22:12
 */
public class HandCursorInitTheme implements MyTheme {
    @Override
    public void initTheme(Component o) {
        o.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
