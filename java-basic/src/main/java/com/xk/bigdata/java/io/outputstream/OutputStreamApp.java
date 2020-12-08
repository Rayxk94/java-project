package com.xk.bigdata.java.io.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamApp {

    public static void main(String[] args) {
        write();
    }

    private static void write() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            // 创建文件字节 输入、输出流
            inputStream = new FileInputStream("java-basic/data/wc.data");
            outputStream = new FileOutputStream("java-basic/out/wc.data");
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, length);
                // 刷新输出字节流
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
