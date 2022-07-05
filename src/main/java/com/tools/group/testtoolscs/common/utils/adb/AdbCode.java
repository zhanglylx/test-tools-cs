package com.tools.group.testtoolscs.common.utils.adb;

import com.tools.group.testtoolscs.common.utils.DynamicSplicing.DynamicSplicing;

/**
 * 最终的父类，用于生成adb命令
 *
 * @author zly
 * @version 1.0
 * @date 2021/1/23 20:30
 */
public interface AdbCode extends DynamicSplicing<String> {

    @Override
    default String separator() {
        return " ";
    }

}
