package com.tools.group.testtoolscs.widget.factory.template;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/18 16:12
 */
@Component
@Scope("prototype")
public class MyImageSliderPanel extends AbstractSliderPanelTemplate<Image> {


    @Override
    public void paintPanel(Graphics g, Image element, int x, int y, int width, int height) {
        g.drawImage(element.getScaledInstance(width, height, Image.SCALE_DEFAULT), x, y, width, height, getBackground(), this);
    }
}
