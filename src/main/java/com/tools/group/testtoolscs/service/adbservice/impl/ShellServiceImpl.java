package com.tools.group.testtoolscs.service.adbservice.impl;

import com.tools.group.testtoolscs.common.utils.adb.AdbCodeFactory;
import com.tools.group.testtoolscs.common.utils.adb.shell.Shell;
import com.tools.group.testtoolscs.service.adbservice.NoShellService;
import com.tools.group.testtoolscs.service.adbservice.ShellService;
import com.tools.group.testtoolscs.widget.MyText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/18 16:58
 */
@Service
public class ShellServiceImpl extends AdbTemplate implements ShellService {
    @Autowired
    private NoShellService noShellService;

    @Override
    public boolean screencap(String src, MyText myText) {
        Shell adbCode = AdbCodeFactory.getShell();
        adbCode.screencap(src);
        return this.execute(adbCode, new Function<List<String>, Boolean>() {
            @Override
            public Boolean apply(List<String> list) {
                return list.size() == 0;
            }
        }, myText);
    }
}
