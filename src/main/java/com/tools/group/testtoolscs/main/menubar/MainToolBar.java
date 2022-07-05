package com.tools.group.testtoolscs.main.menubar;

import com.tools.group.testtoolscs.common.utils.ShowDialogUtils;
import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.handler.ControlLimitsThreadHandler;
import com.tools.group.testtoolscs.main.content.ConloseJTextPane;
import com.tools.group.testtoolscs.service.adbservice.NoShellService;
import com.tools.group.testtoolscs.widget.factory.AbstractJToolBar;
import com.tools.group.testtoolscs.widget.factory.myfactory.MyJButton;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * 这里是工具条
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/8 17:24
 */
@Controller
@Slf4j
public class MainToolBar extends AbstractJToolBar {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ImageConfig imageConfig;
    //    显示设备信息文本
    @Autowired
    private JTextField devicesJText;
    //    显示安卓手机提示文字
    @Autowired
    private JLabel devicesInfo;
    //    设备刷新按钮
    @Autowired
    private MyJButton devicesRefresh;
    @Autowired
    private NoShellService noShellService;
    @Autowired
    private ConloseJTextPane conloseJTextPane;
    @Autowired
    private ExecutorService executorService;

    @Autowired
    private ControlLimitsThreadHandler controlLimitsThreadHandler;

    @Override
    public void myInit() {
        super.myInit();
        initDevices();
    }

    private void initDevices() {
        devicesRefresh.setIcon(new ImageIcon(this.imageConfig.getRefresh()));
        add(devicesRefresh);
        devicesInfo.setText("设备信息：");
        this.add(devicesRefresh);
        this.add(devicesInfo);
        devicesJText.setEditable(false);
        this.add(devicesJText);
        this.executorService.execute(() -> infoDevices(false));
        this.devicesRefresh.addActionListener(e -> {
            devicesJText.setText("正在刷新");
            controlLimitsThreadHandler.Handler(() -> infoDevices(true), this.devicesRefresh);
        });
    }

    /**
     * 设置设备详情
     *
     * @param selectDevices 当设备为多个时，弹窗选项栏
     */
    private void infoDevices(boolean selectDevices) {
        String device = null;
        try {
            Map<String, String> map = noShellService.devices(conloseJTextPane);
            if (map.size() == 0) {
                devicesJText.setText("没有连接的设备");
            } else {
                if (map.size() > 1) {
                    devicesJText.setText("总共连接手机 [" + map.size() + "] ,请手动选择一个设备");
                    if (selectDevices) {
                        String info = ShowDialogUtils.listSelectTooltip("请选择一个设备", new ArrayList<>(map.keySet()));
                        if (info == null) return;
                        device = map.get(info);
                        devicesJText.setText(info);
                    }
                } else {
                    devicesJText.setText(map.keySet().toString());
                    device = map.values().toArray()[0].toString();
                }
            }
        } catch (Exception e) {
            this.devicesJText.setText("初始化设备异常:"+e);
            log.error("初始化设备异常", e);
        }
//        todo 需要使用单例模式设置设备信息
    }

}
