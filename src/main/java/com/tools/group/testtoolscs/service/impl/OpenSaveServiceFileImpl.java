package com.tools.group.testtoolscs.service.impl;

import com.tools.group.testtoolscs.service.OpenSaveFileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 15:36
 */
@Service
public class OpenSaveServiceFileImpl implements OpenSaveFileService {
    @Autowired
    private FileDialog fileDialog;

    @Override
    public File selectFile(String... filter) {
        this.fileDialog.setTitle("请选择文件");
        this.fileDialog.setMode(FileDialog.LOAD);
        this.fileDialog.setFile(StringUtils.join(filter, ","));
        this.fileDialog.setVisible(true);
        this.fileDialog.dispose();
        if (this.fileDialog.getDirectory() != null) {
            return new File(this.fileDialog.getDirectory() + this.fileDialog.getFile());
        }
        return null;
    }

    @Override
    public File saveFile(String fileName) {
        this.fileDialog.setTitle("请选择保存路径");
        this.fileDialog.setMode(FileDialog.SAVE);
        this.fileDialog.setFile(fileName);
        this.fileDialog.setVisible(true);
        this.fileDialog.dispose();
        if (this.fileDialog.getDirectory() != null) {
            String file = this.fileDialog.getDirectory() + this.fileDialog.getFile();
            int index = fileName.lastIndexOf(".");
            if (index != -1) {
                String last = fileName.substring(index);
                if (!file.endsWith(last)) file += last;
            }
            return new File(file);
        }
        return null;
    }

}
