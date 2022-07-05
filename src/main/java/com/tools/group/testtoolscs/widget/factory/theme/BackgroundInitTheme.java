package com.tools.group.testtoolscs.widget.factory.theme;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;

import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/11 21:56
 */
public class BackgroundInitTheme implements MyTheme {
    private static final AppConfig appConfig = StaticApplicationContext.getApplicationContext().getBean(AppConfig.class);

    @Override
    public void initTheme(Component o) {
        o.setBackground(appConfig.getBackgroundColor());
    }
}
