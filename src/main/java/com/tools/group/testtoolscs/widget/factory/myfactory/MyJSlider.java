package com.tools.group.testtoolscs.widget.factory.myfactory;

import com.tools.group.testtoolscs.widget.MyWindow;
import com.tools.group.testtoolscs.widget.factory.theme.InitThemeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 滑动条
 *
 * @author zly
 * @version 1.0
 * @date 2021/2/18 15:03
 */
@Component
@Scope("prototype")
public class MyJSlider extends JSlider implements MyWindow {

    @PostConstruct
    @Override
    public void myInit() {
        InitThemeStrategy.initThemeType(this,
                InitThemeStrategy.InitThemeType.BACKGROUND
                , InitThemeStrategy.InitThemeType.FONT);
        this.setModel(new DefaultBoundedRangeModel(100, 0, 50, 150));
        //        显示尺子数字之间以多少分割，假如范围是50 - 150 ，如果给10的话，代表显示50  60  70。。。 中间以10间隔
        this.setMajorTickSpacing(10);
//        显示尺子的刻度，假如范围是50-150，如果给5的话，代表每5个一个划线，50-  55-  60- ...之间以5间隔
        this.setMinorTickSpacing(5);
//        是否显示缩放数字
        this.setPaintLabels(true);
//        是否显示刻度横线
        this.setPaintTicks(true);
    }

}
