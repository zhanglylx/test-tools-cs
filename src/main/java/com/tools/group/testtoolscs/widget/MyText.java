package com.tools.group.testtoolscs.widget;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/10 10:48
 */
public interface MyText {
    void addText(String text);

    void addErrMessage(String text);

    void addSucMessage(String text);

    void clear();

    void addException(Exception e);
}
