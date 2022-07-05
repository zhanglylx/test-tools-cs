package com.tools.group.testtoolscs.service;

import java.awt.*;
import java.io.File;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 15:35
 */
public interface OpenSaveFileService {
    /**
     * 选择文件
     *
     * @param filter 文件过滤器，一般为文件格式过滤，demo: *.xxx
     * @return 返回null代表取消操作
     */
    File selectFile(String... filter);

    /**
     * 保存文件
     *
     * @param fileName 保存文件名称
     * @return 返回null代表取消操作
     */
    File saveFile(String fileName);

}
