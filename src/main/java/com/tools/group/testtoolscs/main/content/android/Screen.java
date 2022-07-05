package com.tools.group.testtoolscs.main.content.android;

import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.handler.LoopRunnable;
import com.tools.group.testtoolscs.handler.LoopThreadHandler;
import com.tools.group.testtoolscs.service.adbservice.NoShellService;
import com.tools.group.testtoolscs.service.adbservice.ShellService;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.SystemOutPrintText;
import com.tools.group.testtoolscs.widget.factory.AbstractJFrame;
import com.tools.group.testtoolscs.widget.factory.template.MyImageSliderPanel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

/**
 * 抓取android手机屏幕图片并显示在面板上
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/18 11:36
 */
@Component
@Slf4j
public class Screen extends AbstractJFrame implements MyWindow {
    //横向尺子
    @Autowired
    private JSlider horZoomSlider;
    @Autowired
    private JSlider verZoomSlider;

    @Autowired
    private MyImageSliderPanel imagePanel;
    @Autowired
    private ImageConfig imageConfig;

    @Autowired
    private SystemOutPrintText systemOutPrintText;
    @Autowired
    private ShellService shellService;
    @Autowired
    private NoShellService noShell;

    private File imageFile;

    public File getImageFile() {
        return imageFile;
    }


    @Autowired
    private LoopThreadHandler threadExecution;

    @Override
    public void myInit() {
        super.myInit();
        this.setSize(400, 600);
        this.setLayout(new BorderLayout());
        //设置横方向
        this.horZoomSlider.setOrientation(JSlider.HORIZONTAL);
        horZoomSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                imagePanel.setHorScale(((JSlider) e.getSource()).getValue());
            }
        });
        this.add(horZoomSlider, BorderLayout.SOUTH);
        imagePanel.setElement(this.imageConfig.getLogo());
        imagePanel.setCrosswise(this.horZoomSlider.getModel());
//        设置竖向尺子
        this.verZoomSlider.setOrientation(JSlider.VERTICAL);
        this.verZoomSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                imagePanel.setVerScale(((JSlider) e.getSource()).getValue());
            }
        });
        this.add(verZoomSlider, BorderLayout.WEST);
        this.imagePanel.setVertical(this.verZoomSlider.getModel());
        this.add(imagePanel, BorderLayout.CENTER);
        this.imageFile = new File(appConfig.getDependenceDir() + File.separator + "SquirrelScreen.png");
        threadExecution.setWindow(this);
        threadExecution.setRunnable(new RefreshTheImage());
    }

    @Override
    public int close(WindowEvent e) {
        this.imageFile.delete();
        this.stop();
        return super.close(e);
    }

    public void start() {
        threadExecution.start();
    }

    public void stop() {
        threadExecution.stop();
    }

    private class RefreshTheImage implements LoopRunnable {
        @Override
        public boolean run() {
            String src = "/sdcard/SquirrelScreen.png";
            if (shellService.screencap(src, systemOutPrintText) && noShell.pull(src, imageFile.toString(), systemOutPrintText)) {
                try {
                    imagePanel.setElement(ImageIO.read(new File(appConfig.getDependenceDir() + File.separator + "SquirrelScreen.png")));
                    return true;
                } catch (IOException e) {
                    log.error("获取本地图片异常", e);
                }
            }
            return false;
        }
    }
}
