package com.tools.group.testtoolscs.service.adbservice.impl;

import com.tools.group.testtoolscs.common.utils.WindosUtils;
import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.common.utils.adb.AdbUtils;
import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.handler.adbhandler.AdbHandler;
import com.tools.group.testtoolscs.widget.MyText;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 模板方法模式
 * 这里任务的执行采用的委派方式执行
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/9 21:40
 */
public abstract class AdbTemplate {
    @Autowired
    protected AdbHandler adbHandler;

    /**
     * 执行Adb命令并检查执行是否成功
     *
     * @param adbCode
     * @param supplier
     * @param myText
     * @return
     */
    public boolean execute(AdbCode adbCode, Function<List<String>, Boolean> supplier, MyText myText) {
        List<String> result = this.execute(adbCode, myText);
        boolean b = supplier.apply(result);
        if (myText != null) {
            if (b) {
                myText.addSucMessage("执行成功");
            } else {
                myText.addErrMessage("执行失败");
            }
        }
        return b;
    }

    /**
     * 执行adb命令并返回执行结果
     *
     * @param adbCode
     * @param myText
     * @return
     */
    public List<String> execute(AdbCode adbCode, MyText myText) {
        if (myText != null) {
            myText.addText("开始执行命令 :" + adbCode);
        }
        List<String> result = adbHandler.execute(adbCode);
        if (myText != null) {
            result.forEach(myText::addText);
            myText.addText("命令执行完成 :" + adbCode);
        }
        return result;
    }


    public static void main(String[] args) throws IOException, BadLocationException {
        JFrame jframe = new JFrame();
        JTextPane textpane = new JTextPane();
        HTMLEditorKit htmledit = new HTMLEditorKit();
        //实例化一个HTMLEditorkit工具包，用来编辑和解析用来显示在jtextpane中的内容。
        HTMLDocument text_html = (HTMLDocument) htmledit.createDefaultDocument();
        //使用HTMLEditorKit类的方法来创建一个文档类，HTMLEditorKit创建的类型默认为htmldocument。
        textpane.setEditorKit(htmledit);
        //设置jtextpane组件的编辑器工具包，是其支持html格式。
        textpane.setContentType("text/html");
        //设置编辑器要处理的文档内容类型，有text/html,text/rtf.text/plain三种类型。
        textpane.setDocument(text_html);
        SimpleAttributeSet attr = new SimpleAttributeSet();
//实例化一个simpleAttributeSet类。
        StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
        //使用StyleConstants工具类来设置attr属性，这里设置居中属性。
        textpane.setParagraphAttributes(attr, false);
        //设置段落属性，第二个参数为false表示不覆盖以前的属性，如果选择true，会覆盖以前的属性。
        Color color = JColorChooser.showDialog(null, "color title", Color.BLACK);
        StyleConstants.setForeground(attr, color);
        //设置颜色属性，参数为color类型。
        textpane.setCharacterAttributes(attr, false);
        jframe.add(textpane);
        jframe.setVisible(true);
        htmledit.insertHTML(text_html, 0, "ttt", 2, 2, HTML.Tag.HTML);
    }
}
