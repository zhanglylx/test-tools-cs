package com.tools.group.testtoolscs.widget.factory.theme;

import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;

import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/11 21:57
 */
public class IconInitTheme implements MyTheme {
    private static final ImageConfig imageConfig = StaticApplicationContext.getApplicationContext().getBean(ImageConfig.class);

    @Override
    public void initTheme(Component o) {
        ((Window)(o)).setIconImage(imageConfig.getLogo());
    }
}
