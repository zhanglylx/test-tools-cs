package com.tools.group.testtoolscs;

import com.tools.group.testtoolscs.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * 工程基于spirngboot创建
 * 大控件由spirng ioc 以单例模式管理，在程序初始化阶段加载
 * 小的装饰组件由spring创建为多例模式，最终这些小装饰组件存在于大组件内，对于大组件来说，他们也是单例模式
 * 本工程在结构设计模式上，使用了工厂模式，门面模式，委派模式，模板方法模式，享元模式，单例模式，代理模式，策略模式,桥接模式
 * 工厂模式:所有的控件在项目中进行了默认封装，用户只需要继承或通过spring引用创建，无需关心创建过程
 * 门面模式:帮助提供给控件的初始化等操作
 * 模板方法模式:如执行adb命令执行，进行了步骤的封装
 * 享元模式：如获取adbCode接口时，通过使用threadlocal进行了对线程的封装，按单个线程来说，会缓存已创建的对象
 * 代理模式: 如通过代理模式自动解析并创建adbCode对应的命令码
 * 策略模式: 如初始化组件时要默认加入多种不同的样式，比如字体，背景等，使用策略模式将字体，背景等单独进行算法封装，创建一个上下文，将支持的类型
 * 交给用户(即每个组件)去决定要使用哪种一种或多种算法添加默认样式
 * 桥接模式: 如在item小控件有很多中，而组件都可以添加这种小控件，不能一个组件对应一个小控件，那这种代码量和冗余太多了，使用桥接模式，提前定义好的小控制
 * 右客户端自己选择，然后通过桥接方式，将想要使用小控件的组件和对应的小控件之间进行相关联并且这个桥是单例模式，因为这种控件弹出以后，用户必须要操作，
 * 所以这个弹出控件出现即在用户顶层，用户必须操作这个弹出控件后才能继续操作其他功能，这个设计考虑到了后续扩展问题，符合开闭原则，并且如果
 * 存在多并发的情况下，可以直接使用spring的多例模式解决或在代码中进行线程安全处理
 * 装饰器模式:对Adb执行进行了扩展，使用装饰器模式进行了解耦，因本项目工程中需要进行adb绝对路径拼接，adb指定设备获取并拼接，然后才到执行，所以将每一个任务责任单独
 * 进行了拆分，使用装饰器模式将结构将串联起来
 */
@SpringBootApplication(scanBasePackages = "com.tools.group", exclude = DataSourceAutoConfiguration.class)
public class TestToolsCsApplication {
    static {
        System.setProperty("java.awt.headless", "false");
    }

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(TestToolsCsApplication.class, args);
        app.getBean(Main.class).setVisible(true);
//        JFrame jFrame = new JFrame("=--------");
//        jFrame.setSize(1000,1000);
//        JButton jButton = new JButton("sfsfsd");
//        jButton.addActionListener(new OpenFrameActionListener(JFrame.class));
//        jFrame.add(jButton);
//        JMenuBar jMenuBar = new JMenuBar();
//        JMenu menu = new JMenu("File");
//        JMenuItem menuItem = new JMenuItem("New");
//        JMenuItem menuItem12 = new JMenuItem("New");
//        JMenuItem menuItem2 = new JMenuItem("New");
//        JMenuItem menuItem3 = new JMenuItem("New");
//        menu.add(menuItem);
//        menu.add(menuItem12);
//        menu.add(menuItem2);
//        menu.add(menuItem3);
//        jMenuBar.add(menu);
//        jFrame.setJMenuBar(jMenuBar);
//        jFrame.setVisible(true);

    }

}
