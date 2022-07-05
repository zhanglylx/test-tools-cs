package com.tools.group.testtoolscs.main.content.android;

import com.tools.group.testtoolscs.common.utils.WindosUtils;
import com.tools.group.testtoolscs.main.content.ConloseJTextPane;
import com.tools.group.testtoolscs.service.OpenSaveFileService;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import com.tools.group.testtoolscs.widget.factory.listener.MyComponentListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.io.File;

/**
 * 抓取手机屏幕
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/18 11:17
 */
@Component
public class GrabScreen extends AbstractJPanel implements MyWindow {
    @Autowired
    private Screen screen;
    //    截取复制文件按钮
    @Autowired
    private JButton captureImageButton;
    @Autowired
    private OpenSaveFileService openSaveFile;
    @Autowired
    private ConloseJTextPane conloseJTextPane;

    @Override
    public void myInit() {
        super.myInit();
        this.setName("GrabScreen");
        this.setLayout(new GridLayout(2, 1));
        this.addComponentListener(new MyComponentListener() {
            @Override
            public void componentShown(ComponentEvent e) {
                screen.start();
                screen.setVisible(true);
            }
        });
        captureImageButton.setText("截取屏幕");
        captureImageButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!screen.getImageFile().exists()) {
                    conloseJTextPane.addErrMessage("需要复制的文件不存在");
                    return;
                }
                File file = openSaveFile.saveFile("squirrel.png");
                if (file != null) {
                    if (WindosUtils.copyFile(screen.getImageFile(), file)) {
                        conloseJTextPane.addSucMessage("复制成功:" + file);
                    } else {
                        conloseJTextPane.addErrMessage("复制失败:" + file);
                    }
                }
            }
        });
        this.add(captureImageButton);
    }
}
