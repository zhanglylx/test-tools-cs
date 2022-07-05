package com.tools.group.testtoolscs.service.adbservice;

import com.tools.group.testtoolscs.widget.MyText;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/9 16:28
 */
public interface NoShellService {

    boolean install(File file, MyText message);

    boolean pull(String src,String tar,MyText message);

    Map<String,String> devices(MyText message);
}
