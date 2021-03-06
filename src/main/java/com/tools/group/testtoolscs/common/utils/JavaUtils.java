package com.tools.group.testtoolscs.common.utils;



import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtils {


    /**
     * 获取文件后缀名称
     *
     * @return
     */
    public static String getFileSuffixName(File file) throws IllegalArgumentException {
        if (file == null) throw new IllegalArgumentException("文件为空");
        if (!file.exists()) throw new IllegalArgumentException("文件不存在:" + file.getPath());
        if (file.getName().lastIndexOf(".") == -1) throw
                new IllegalArgumentException("不是一个文件:" + file.getName());
        return file.getName().substring(
                file.getName().lastIndexOf(".") + 1, file.getName().length());
    }

    public static boolean isDateString(String datevalue, String dateFormat) {
        if (datevalue == null || dateFormat == null) return false;
        if (datevalue.equals("") || dateFormat.equals("")) return false;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
            java.util.Date dd = fmt.parse(datevalue);
            if (datevalue.equals(fmt.format(dd))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 获取随机数
     *
     * @param min
     * @param max
     * @return
     */

    public static int getRandomNumbers(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }


    /**
     * 生成md5
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte messageDigest[] = md5.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String t = Integer.toHexString(0xFF & messageDigest[i]);
                if (t.length() == 1) {
                    hexString.append("0" + t);
                } else {
                    hexString.append(t);
                }
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 编辑距离算法
     * 编辑距离的两字符串相似度
     *
     * @author jianpo.mo
     */

    private static int min(int one, int two, int three) {
        int min = one;
        if (two < min) {
            min = two;
        }
        if (three < min) {
            min = three;
        }
        return min;
    }

    /**
     * 检查字符串匹配度
     *
     * @param str1
     * @param str2
     * @return 未匹配成功数量
     */
    public static int ld(String str1, String str2) {
        int d[][];    //矩阵
        int n = str1.length();
        int m = str2.length();
        int i;    //遍历str1的
        int j;    //遍历str2的
        char ch1;    //str1的
        char ch2;    //str2的
        int temp;    //记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {    //初始化第一列
            d[i][0] = i;
        }
        for (j = 0; j <= m; j++) {    //初始化第一行
            d[0][j] = j;
        }
        for (i = 1; i <= n; i++) {    //遍历str1
            ch1 = str1.charAt(i - 1);
            //去匹配str2
            for (j = 1; j <= m; j++) {
                ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    /**
     * 字符串的相似度
     *
     * @param str1
     * @param str2
     * @return
     */
    public static double sim(String str1, String str2) {
        int ld = ld(str1, str2);
        return 1 - (double) ld / Math.max(str1.length(), str2.length());
    }

    /**
     * 替换换行符
     *
     * @param str       替换字符串
     * @param alternate 替换内容
     * @return
     */
    public static String replaceLineBreak(String str, String alternate) {
        Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
        Matcher m = CRLF.matcher(str);
        if (m.find()) {
            str = m.replaceAll(alternate);
        }
        return str;
    }

    /**
     * 获取本地txt文件内容
     *
     * @param file
     * @return
     */
    public static List<String> getLocaFileTxt(File file) throws IOException {
        if (file == null) throw new NullPointerException("file为空");
        if (!file.exists()) throw new IllegalArgumentException("文件不存在:" + file.getPath());
        if (!file.getName().toLowerCase().endsWith(".txt"))
            throw new IllegalArgumentException("不是txt文件:" + file.getPath());
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(new FileInputStream(file), "UTF-8")
                    );
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                list.add(msg);
            }
        } finally {
            if (bufferedReader != null) bufferedReader.close();
        }
        return list;
    }

    /**
     * 获取本地桌面路径
     *
     * @return
     */
    public static File getLocalDesktopPath() {
        return FileSystemView.getFileSystemView().getHomeDirectory();
    }

    /**
     * 随机生成一个中文字符
     *
     * @return
     */
    public static String getRandomChinese() {
        return new String(new char[]{(char) (new Random().nextInt(20902) + 19968)});
    }

    /**
     * 随机生成一个中文字符
     *
     * @param lenth 指定长度
     * @return
     */
    public static String getRandomChinese(int lenth) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lenth; i++) {
            stringBuffer.append(getRandomChinese());
        }
        return stringBuffer.toString();
    }



    /**
     * 数组添加内容
     * @param objects
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T arraysLenthAdd(Object[] objects, Object ... object) {
        for(Object o:object){
            objects = Arrays.copyOf(objects, objects.length + 1);
            objects[objects.length - 1] = o;
        }
        return (T) objects;
    }

    /**
     * java方法
     */
    private void fangfa() {

        try {
            System.in.read();//按任意键
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}