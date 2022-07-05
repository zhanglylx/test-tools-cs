package com.tools.group.testtoolscs.widget.factory.template;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.AbstractJPanel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 可以左右上下改动的面板
 * 使用模板方法模式
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/18 11:45
 */
public abstract class AbstractSliderPanelTemplate<T> extends AbstractJPanel implements MyWindow {
    private T element;
    private int horScale = 100;
    private int verScale = 100;
    private BoundedRangeModel crosswise;
    private BoundedRangeModel vertical;

    public void setVertical(BoundedRangeModel vertical) {
        this.vertical = vertical;
    }

    public void setCrosswise(BoundedRangeModel crosswise) {
        this.crosswise = crosswise;
    }

    public void setElement(T element) {
        this.element = element;
        repaint();
    }

    public void setHorScale(int scale) {
        horScale = scale;
        repaint();
    }

    public void setVerScale(int scale) {
        verScale = scale;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        System.out.println(w);
        System.out.println(h);
//        横向偏移量
        int crosswiseOffset = 101, verticalOffset = 101;
        if (this.crosswise != null && this.crosswise.getMaximum() > crosswiseOffset)
            crosswiseOffset += this.crosswise.getMaximum() - crosswiseOffset;
//        竖向偏移量
        if (this.vertical != null && this.vertical.getMaximum() > verticalOffset)
            verticalOffset += this.vertical.getMaximum() - verticalOffset;
        int wi = w * horScale / crosswiseOffset;
        int hi = h * verScale / verticalOffset;
        int x = (w - wi) >> 1;
        int y = (h - hi) >> 1;
        g.setColor(getBackground());
        g.fillRect(0, 0, w, h);
        paintPanel(g, element, x, y, wi, hi);
    }

    /**
     * 使用钩子方法让用户自己制定绘制内容
     *
     * @param g
     * @param element
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public abstract void paintPanel(Graphics g, T element, int x, int y, int width, int height);


}
