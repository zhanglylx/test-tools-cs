package com.tools.group.testtoolscs.widget;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.IOException;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/5 17:15
 */

public interface MyWindow {
    @PostConstruct
    default void myInit()  {

    }

}
