package com.tools.group.testtoolscs.main.content.android;

import com.tools.group.testtoolscs.handler.ControlLimitsThreadHandler;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.main.content.ConloseJTextPane;
import com.tools.group.testtoolscs.service.OpenSaveFileService;
import com.tools.group.testtoolscs.service.adbservice.NoShellService;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 安装apk面板
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/8 18:19
 */
@Component
public class InstallApk extends AbstractJPanel implements MyWindow {
    @Autowired
    private ConloseJTextPane conloseJTextPane;
    @Autowired
    private JTextField jTextField;
    @Autowired
    private OpenSaveFileService openSaveFile;
    @Autowired
    private NoShellService noShellService;
    @Autowired
    private JButton selectApkButton;
    @Autowired
    private JButton installApkButton;
    @Autowired
    private ControlLimitsThreadHandler controlLimitsThreadHandler;

    @Override
    public void myInit() {
        super.myInit();
        this.setName("InstallApk");
        this.setLayout(new GridLayout(3, 1));
        this.jTextField.setColumns(40);
        this.jTextField.setText("请选择一个.apk文件");
        this.jTextField.setToolTipText("请选择一个.apk文件");
        this.selectApkButton.setText("请选择文件");
        this.selectApkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = openSaveFile.selectFile("*.apk");
                if (file == null) {
                    jTextField.setText("请选择一个.apk文件");
                } else {
                    jTextField.setText(file.toString());
                }
            }
        });
        this.add(this.selectApkButton);
        this.add(jTextField);
        this.installApkButton.setText("安装");
        this.installApkButton.addActionListener(e -> {
            this.controlLimitsThreadHandler.Handler(
                    () ->
                            noShellService.install(
                                    new File(jTextField.getText()),
                                    conloseJTextPane),
                    this.installApkButton);
        });
        this.add(this.installApkButton);
    }
}
