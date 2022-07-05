package com.tools.group.testtoolscs.main;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.main.menubar.MainMenuBar;
import com.tools.group.testtoolscs.widget.factory.AbstractJFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.WindowEvent;

/**
 * 工程的主入口
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/5 10:11
 */
@Controller
//@Scope("prototype")
public class Main extends AbstractJFrame {
    @Autowired
    private MainMenuBar mainMenuBar;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private MainContentPane contentPane;

    @Override
    public void myInit() {
        super.myInit();
        this.setTitle("松鼠测试中心");
        this.setSize(appConfig.getWidth(), appConfig.getHeight());
        initMenuBar();
        initContentPane();
        this.setLocationRelativeTo(null);
    }

    private void initContentPane() {
        this.setContentPane(this.contentPane);
    }


    private void initMenuBar() {
        this.setJMenuBar(mainMenuBar);
    }

    @Override
    public int close(WindowEvent e) {
        System.exit(0);
        return super.close(e);
    }
}
