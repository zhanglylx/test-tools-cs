package com.tools.group.testtoolscs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 15:37
 */
@Configuration
public class WidgetConfig {
    @Bean
    public FileDialog getFileDialog() {
        return new FileDialog(JOptionPane.getFrameForComponent(null));
    }


}
