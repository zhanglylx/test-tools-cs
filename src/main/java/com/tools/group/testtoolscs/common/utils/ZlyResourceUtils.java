package com.tools.group.testtoolscs.common.utils;

import javafx.scene.effect.ImageInput;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zly
 * @version 1.0
 * @date 2021/2/5 17:45
 */
public class ZlyResourceUtils {

    public static InputStream getResourceInputStream(String path) throws IOException {
        return new ClassPathResource(path).getInputStream();
    }

    public static BufferedImage getImageInputStream(String path) throws IOException {
        return ImageIO.read(getResourceInputStream(path));
    }

}
