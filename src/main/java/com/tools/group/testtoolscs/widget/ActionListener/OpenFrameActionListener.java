package com.tools.group.testtoolscs.widget.ActionListener;

import lombok.Data;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/4 10:34
 */
@Data
public class OpenFrameActionListener implements ActionListener {
    private Class<? extends JFrame> clazz;

    public OpenFrameActionListener(Class<? extends JFrame> clazz) {
        this.clazz = clazz;
    }

    @Override
    public final void actionPerformed(ActionEvent e) {

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                String title = null;
                Object source = e.getSource();
                if (source instanceof AbstractButton) {
                    title = ((AbstractButton) source).getText();
                }
                JFrame frame = clazz.newInstance();
                frame.setTitle(title);
            }
        }).start();
    }
}
