package com.tools.group.testtoolscs.common.utils;

import com.tools.group.testtoolscs.config.AppConfig;
import com.tools.group.testtoolscs.config.ImageConfig;
import com.tools.group.testtoolscs.config.StaticApplicationContext;
import org.apache.commons.lang3.ArrayUtils;

import javax.swing.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * 提示框
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/9 14:48
 */
public class ShowDialogUtils {

    public static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "错误提示", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "消息提示", JOptionPane.INFORMATION_MESSAGE);

    }

    public static String listSelectTooltip(String message, List<?> items) {
        return listSelectTooltip(message, items.toArray());
    }

    public static String listSelectTooltip(String message, Object... list) {
        Object o = JOptionPane.showInputDialog(null,
                message + ":\n", "提示",
                JOptionPane.PLAIN_MESSAGE, null, list, list[0]);
        if (o == null) return null;
        return o.toString();
    }

}
