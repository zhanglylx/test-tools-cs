package com.tools.group.testtoolscs.handler.adbhandler;

import com.tools.group.testtoolscs.common.utils.adb.AdbCode;
import com.tools.group.testtoolscs.widget.MyText;

import java.util.List;
import java.util.function.Function;

/**
 * 使用责任链模式处理Adb命令执行
 * 因整体项目采用spirngboot方式，要考虑线程安全问题
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/20 19:15
 */
public interface AdbHandler {

     List<String> execute(AdbCode adbCode);

}
