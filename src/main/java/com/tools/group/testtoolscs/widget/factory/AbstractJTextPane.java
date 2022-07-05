package com.tools.group.testtoolscs.widget.factory;

import com.tools.group.testtoolscs.common.utils.ZLYDateUtils;
import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.widget.MyScroll;
import com.tools.group.testtoolscs.widget.MyText;
import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.myfactory.MyJScrollPane;
import com.tools.group.testtoolscs.widget.factory.myfactory.small.itembridge.MouseRightJMenuBridge;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 9:47
 */

public abstract class AbstractJTextPane extends JTextPane implements MyWindow, MyText, MyScroll {
    private StyledDocument sDocument;
    @Autowired
    protected AppConfig appConfig;
    @Autowired
    private MyJScrollPane myJScrollPane;
    @Autowired
    MouseRightJMenuBridge mouseRightJMenuBridge;

    @PostConstruct
    @Override
    public void myInit() {
        this.sDocument = this.getStyledDocument();
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT
                , InitThemeStrategy.InitThemeType.MARGIN);
        mouseRightJMenuBridge.relevance(this);
    }

    @Override
    public JScrollPane getScrollPane() {
        myJScrollPane.setViewportView(this);
        return myJScrollPane;
    }

    public void addErrMessage(String errorMessage) {
        this.insert(getFontAttrib(errorMessage, appConfig.getFont(), appConfig.getErrColor(), null));
    }

    @Override
    public void addSucMessage(String text) {
        this.insert(getFontAttrib(text, appConfig.getFont(), appConfig.getSucColor(), null));
    }

    @Override
    public void addText(String text) {
        this.insert(getFontAttrib(text, appConfig.getFont(), appConfig.getDefaultColor(), null));
    }

    @Override
    public void addException(Exception e) {
        this.addErrMessage(e.getMessage());
    }

    @Override
    public void clear() {
        this.setText("");
    }

    /**
     * 获取要插入的文本属性
     *
     * @param text      文本内容
     * @param font      字体
     * @param fontColor 字体颜色
     * @param backColor 字体背景颜色
     * @return
     */
    public FontAttrib getFontAttrib(String text, Font font, Color fontColor, Color backColor) {
        FontAttrib att = new FontAttrib();
        att.setText(ZLYDateUtils.getStrSysSpecifiedFormat("HH:mm:ss") + " " + text + "\n");
        att.setName(font.getName());
        att.setSize(font.getSize());
        att.setStyle(font.getStyle());
        att.setColor(fontColor);
        att.setBackColor(backColor);
        return att;
    }

    private void insert(FontAttrib attrib) {
        try { // 插入文本

            this.sDocument.insertString(this.sDocument.getLength(), attrib.getText(),
                    attrib.getAttrSet());
            this.setCaretPosition(this.sDocument.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private class FontAttrib {
        public static final int GENERAL = Font.PLAIN; // 常规
        public static final int BOLD = Font.BOLD; // 粗体
        public static final int ITALIC = Font.ITALIC; // 斜体
        public static final int BOLD_ITALIC = 3; // 粗斜体
        private SimpleAttributeSet attrSet = null; // 属性集
        private String text = null, name = null; // 要输入的文本和字体名称
        private int style = 0, size = 0; // 样式和字号
        private Color color = null, backColor = null; // 文字颜色和背景颜色


        public FontAttrib() {
        }

        public SimpleAttributeSet getAttrSet() {
            attrSet = new SimpleAttributeSet();
            if (name != null) {
                StyleConstants.setFontFamily(attrSet, name);
            }
            if (style == FontAttrib.GENERAL) {
                StyleConstants.setBold(attrSet, false);
                StyleConstants.setItalic(attrSet, false);
            } else if (style == FontAttrib.BOLD) {
                StyleConstants.setBold(attrSet, true);
                StyleConstants.setItalic(attrSet, false);
            } else if (style == FontAttrib.ITALIC) {
                StyleConstants.setBold(attrSet, false);
                StyleConstants.setItalic(attrSet, true);
            } else if (style == FontAttrib.BOLD_ITALIC) {
                StyleConstants.setBold(attrSet, true);
                StyleConstants.setItalic(attrSet, true);
            }
            StyleConstants.setFontSize(attrSet, size);
            if (color != null) {
                StyleConstants.setForeground(attrSet, color);
            }
            if (backColor != null) {
                StyleConstants.setBackground(attrSet, backColor);
            }
            return attrSet;
        }

        public void setAttrSet(SimpleAttributeSet attrSet) {
            this.attrSet = attrSet;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getBackColor() {
            return backColor;
        }

        public void setBackColor(Color backColor) {
            this.backColor = backColor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }
}
