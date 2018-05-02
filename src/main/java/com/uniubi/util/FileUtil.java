package com.uniubi.util;

import java.io.*;

/**
 * @author 启明
 * @create 2018年01月25日
 */
public class FileUtil {
    public static void contentToTxt(String content, String filePath) {
        String previousStr = new String();
        String updateStr = new String();
        try {
            File f = new File(filePath);
            if (f.exists()) {
            } else {
                f.createNewFile();// 不存在则创建
            }
            BufferedReader input = new BufferedReader(new FileReader(f));

            while ((previousStr = input.readLine()) != null) {
                updateStr += previousStr + "\n";
            }
            input.close();
            updateStr += content;

            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(updateStr);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
