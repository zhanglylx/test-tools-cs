package com.tools.group.testtoolscs.config;

import com.tools.group.testtoolscs.common.utils.ZlyResourceUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/5 11:59
 */
@Configuration
@ConfigurationProperties(prefix = "image")
public class ImageConfig {
    private BufferedImage logo;
    //    刷新图片
    private BufferedImage refresh;

    public BufferedImage getLogo() {
        return logo;
    }

    public BufferedImage getRefresh() {
        return refresh;
    }

    public void setLogo(String logo) throws IOException {
        this.logo = ZlyResourceUtils.getImageInputStream(logo);
        ;
    }

    public void setRefresh(String refresh) throws IOException {
        this.refresh = ZlyResourceUtils.getImageInputStream(refresh);
        ;
    }
}
