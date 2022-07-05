package com.tools.group.testtoolscs.common.utils.adb.shell;

import com.tools.group.testtoolscs.common.utils.adb.AdbCode;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/18 16:55
 */
public interface Shell extends AdbCode {
    @Override
    default String init() {
        return "adb shell ";
    }

    default String screencap(String path) {
        if (path == null) return "-p";
        return " -p " + path;
    }


}
