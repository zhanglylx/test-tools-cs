package com.tools.group.testtoolscs.config;

import com.sun.nio.zipfs.ZipFileSystem;
import com.tools.group.testtoolscs.common.utils.ZipUtils;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/5 18:34
 */
@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String version;
    private String dependenceDir;
    private List<String> copyFile;
    private String adbExe;
    private int width;
    private int height;
    private Font font;
    private Color backgroundColor;
    private Default defaultSetting;
    private Color errColor;
    private Color sucColor;
    private Color defaultColor;

    @Data
    public static class Default {
        private Map<String, String> font;
        private Map<String, Integer> backgroundColor;
    }


    @PostConstruct
    public void init() {
        this.font = new Font(this.defaultSetting.getFont().get("name"), Integer.parseInt(this.defaultSetting.getFont().get("style")), Integer.parseInt(this.defaultSetting.getFont().get("size")));
        this.backgroundColor = new Color(this.defaultSetting.getBackgroundColor().get("r"),
                this.defaultSetting.getBackgroundColor().get("g"),
                this.defaultSetting.getBackgroundColor().get("b"));
        this.errColor = Color.RED;
        this.sucColor = Color.GREEN;
        this.defaultColor = Color.BLACK;
        File file = new File(dependenceDir);
        this.dependenceDir = file.toString();
        if (!file.exists()) {
            if (!file.mkdirs()) throw new RuntimeException("create dir fail:" + dependenceDir);
        }
        List<File> list = new ArrayList<>();
        copyFile.forEach(new Consumer<String>() {
            @SneakyThrows
            @Override
            public void accept(String s) {
                File file = new File(dependenceDir + "/" + s);
                if (!file.getParentFile().exists())
                    if (!file.getParentFile().mkdirs()) throw new RuntimeException("create dir fail:" + dependenceDir);
                Resource resource = new ClassPathResource(s);
                try (InputStream inputStream = resource.getInputStream()) {
                    Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                list.addAll(ZipUtils.unzipFile(file, new File(dependenceDir), true, StandardCharsets.UTF_8));
            }
        });
        list.forEach(new Consumer<File>() {
            @Override
            public void accept(File file) {
                if ("adb.exe".equals(file.getName())) {
                    adbExe = file.toString();
                }
            }
        });
    }

}
