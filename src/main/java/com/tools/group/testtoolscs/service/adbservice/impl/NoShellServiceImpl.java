package com.tools.group.testtoolscs.service.adbservice.impl;

import com.tools.group.testtoolscs.common.utils.adb.AdbCodeFactory;
import com.tools.group.testtoolscs.common.utils.adb.NoShell;
import com.tools.group.testtoolscs.service.adbservice.NoShellService;
import com.tools.group.testtoolscs.widget.MyText;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 16:29
 */
@Service
public class NoShellServiceImpl extends AdbTemplate implements NoShellService {

    @Override
    public boolean install(File file, MyText myText) {
        NoShell noShell = AdbCodeFactory.getNoShell();
        noShell.install(file);
        return this.execute(noShell, list1 -> {
            if (list1.size() == 0) return false;
            return "Success".equals(list1.get(list1.size() - 1).trim());
        }, myText);
    }

    @Override
    public boolean pull(String src, String tar, MyText myText) {
        NoShell noShell = AdbCodeFactory.getNoShell();
        noShell.pull(src, tar);
        return this.execute(noShell, new Function<List<String>, Boolean>() {
            @Override
            public Boolean apply(List<String> list) {
                return list.get(list.size() - 1).contains("pulled");
            }
        }, myText);
    }

    @Override
    public Map<String, String> devices(MyText message) {
        NoShell noShell = AdbCodeFactory.getNoShell();
        noShell.devices();
        List<String> list = this.execute(noShell, message);
        Map<String, String> map = new HashMap<>();
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                String devices = list.get(i);
                if (!devices.toLowerCase().contains("device")) continue;
                String imei = devices.substring(0, devices.indexOf(" "));
                String key = devices.substring(devices.indexOf("device") + 6);
                map.put(key, imei);
            }
            return map;
        }
        return null;
    }


}
