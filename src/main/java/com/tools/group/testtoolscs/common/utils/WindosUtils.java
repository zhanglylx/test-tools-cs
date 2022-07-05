package com.tools.group.testtoolscs.common.utils;

import com.tools.group.testtoolscs.common.utils.adb.AdbUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class WindosUtils {

    public static List<String> dosExecute(String code) {
        return dosExecute(code, false, true, true);
    }

    public static List<String> dosExecute(String code, boolean isWait, boolean isInputStream, boolean isErrorStream) {
        List<String> list = new ArrayList<>();
        Process pro = null;
        BufferedReader br = null;
        try {
            pro = Runtime.getRuntime().exec(code);
            if (isWait) pro.waitFor();
            if (isInputStream) {
                br = new BufferedReader(new InputStreamReader(pro.getInputStream(), StandardCharsets.UTF_8));
                list.addAll(getBufferedReader(br));
            }
            if (isErrorStream) {
                //获取错误流
                br = new BufferedReader(new InputStreamReader(pro.getErrorStream(), StandardCharsets.UTF_8));
                list.addAll(getBufferedReader(br));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(br, pro);
        }
        return list;
    }

    /**
     * 这个方法暂时应该是不可用，使用这个方法获取下的流数组想转化成对应的文件，但是不能转化成功
     *
     * @param code
     * @return
     */
    @SneakyThrows
    public static byte[] dosExecuteByte(String code) {
        Process pro = null;
        InputStream inputStream = null;
        byte[] bytes = new byte[0];
        try {
            pro = Runtime.getRuntime().exec(code);
            inputStream = pro.getInputStream();
            while (true) {
                byte b = (byte) inputStream.read();
                System.out.println(b);
                if (b == -1) break;
                bytes = ArrayUtils.add(bytes, b);
            }
            System.out.println(Arrays.toString(bytes));
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) inputStream.close();
            if (pro != null) pro.destroy();
        }
        return null;
    }


    /**
     * 读取adb缓冲流
     *
     * @return
     */
    public static List<String> getBufferedReader(BufferedReader br) throws IOException {
        String msg;
        List<String> list = new ArrayList<>();
        while ((msg = br.readLine()) != null) {
            list.add(msg);
            System.out.println(msg);
        }
        return list;
    }

    public static void close(BufferedReader bufferedReader, Process process) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (process != null) process.destroy();
    }

    /**
     * 复制文件
     */
    public static boolean copyFile(File src, File tar) {
        try (FileChannel inFileChannel = FileChannel.open(Paths.get(src.getPath()), StandardOpenOption.READ);
             FileChannel outFileChannel = FileChannel.open(tar.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.READ)) {
            zeroCopy(inFileChannel, outFileChannel);
            return true;
//            MappedByteBuffer 只有在GC回收时才会被释放资源,
//            MappedByteBuffer inMappedByteBuffer = inFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inFileChannel.size());
//            MappedByteBuffer outMappedByteBuffer = outFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, inFileChannel.size());
//            outMappedByteBuffer.put(inMappedByteBuffer);
        } catch (Exception e) {
            log.error("复制文件发生异常", e);
        }
        return false;
    }

    private static void zeroCopy(FileChannel fileChannel, WritableByteChannel target) throws IOException {
        long size = fileChannel.size();
        long position = 0;
        while (size > 0) {
            long tf = fileChannel.transferTo(position, size, target);
            if (tf > 0) {
                position += tf;
                size -= tf;
            }
        }
    }
}
