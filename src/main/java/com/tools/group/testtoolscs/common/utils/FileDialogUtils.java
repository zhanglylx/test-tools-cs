package com.tools.group.testtoolscs.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 15:19
 */
public class FileDialogUtils {

    /**
     * 选择文件框
     */
    public static File selectFile(Component parent, String... filter) {
        FileDialog fileDialog = new FileDialog(JOptionPane.getFrameForComponent(parent), "请选择文件", FileDialog.LOAD);
        fileDialog.setFile(StringUtils.join(filter, ","));
        fileDialog.setVisible(true);
        fileDialog.dispose();
        if (fileDialog.getDirectory() != null) {
            return new File(fileDialog.getDirectory() + fileDialog.getFile());
        }
        return null;
    }

}
