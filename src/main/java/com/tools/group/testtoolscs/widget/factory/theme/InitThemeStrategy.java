package com.tools.group.testtoolscs.widget.factory.theme;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用策略模式进行初始化
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/11 22:02
 */
public class InitThemeStrategy {
    private static final Map<InitThemeType, MyTheme> initStrategy = new HashMap<>();

    public enum InitThemeType {
        FONT,
        BACKGROUND,
        ICON,
        HAND_CURSOR,
        MARGIN;
    }

    static {
        initStrategy.put(InitThemeType.FONT, new FontInitTheme());
        initStrategy.put(InitThemeType.BACKGROUND, new BackgroundInitTheme());
        initStrategy.put(InitThemeType.ICON, new IconInitTheme());
        initStrategy.put(InitThemeType.HAND_CURSOR, new HandCursorInitTheme());
        initStrategy.put(InitThemeType.MARGIN, new MarginInitTheme());
    }

    public static void initThemeType(Component component, InitThemeType... initThemeTypes) {
        for (InitThemeType item : initThemeTypes) {
            initStrategy.get(item).initTheme(component);
        }
    }

}
