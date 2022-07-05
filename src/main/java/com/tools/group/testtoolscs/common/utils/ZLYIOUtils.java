package com.tools.group.testtoolscs.common.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZLYIOUtils {

    public static void getClassPathResource(String... paths) throws IOException {
        for (String path : paths) {
            getClassPathResource(path);
        }
    }

    public static File getClassPathResource(String path) throws IOException {
        return getClassPathResource(path, path);
    }

    public static File getClassPathResource(String copyPath, String path) throws IOException {
        File inuModel = new File(copyPath);
        Resource resource = new ClassPathResource(path);
        if (!inuModel.getParentFile().exists()) {
            if (!inuModel.getParentFile().mkdirs()) {
                throw new IOException(copyPath + " create fail");
            }
        }
        try (InputStream in = resource.getInputStream(); FileOutputStream out = new FileOutputStream(inuModel)) {
//            IOUtils.copy(in, out);

        }
        return inuModel;
    }
}
