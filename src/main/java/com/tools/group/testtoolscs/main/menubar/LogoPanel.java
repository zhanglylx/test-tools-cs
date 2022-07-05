package com.tools.group.testtoolscs.main.menubar;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import com.tools.group.testtoolscs.widget.factory.template.AbstractSliderPanelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * 关于logo
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/5 18:10
 */
@Component
public class LogoPanel extends AbstractJPanel {
    @Autowired
    private ImageConfig imageConfig;
    @Autowired
    private AppConfig appConfig;
    private Dimension size;

    private JComponent parent;

    public Dimension getPreferredSize() {
        return size;
    }

    public void setParent(JComponent parent) {
        this.parent = parent;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int coordinateY = 0;
//        if (this.parent != null) {
//            coordinateY = this.parent.getHeight() - this.imageConfig.getLogo().getHeight();
//            if (coordinateY > 0) coordinateY = coordinateY >> 1;
//        }
        //将图片绘制到喷洒到面板上
        g.drawImage(this.imageConfig.getLogo(), 0, coordinateY, this);
        int x = (int) (this.imageConfig.getLogo().getWidth() * 0.6);
        int y = (int) (this.imageConfig.getLogo().getHeight() * 0.9);
        Object rh = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
//        文字抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setFont(getFont());
        g2d.setColor(Color.ORANGE);
        g2d.drawString(appConfig.getVersion(), x + 3, y + 2);
        g2d.setColor(getForeground());
        g2d.drawString(appConfig.getVersion(), x, y);
        g2d.drawString(appConfig.getVersion(), x + 1, y);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, rh);
    }


    @PostConstruct
    @Override
    public void myInit() {
        super.myInit();
        size = new Dimension(this.imageConfig.getLogo().getWidth(), this.imageConfig.getLogo().getHeight());
    }
}
