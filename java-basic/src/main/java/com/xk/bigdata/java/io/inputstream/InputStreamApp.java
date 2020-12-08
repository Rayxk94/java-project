package com.xk.bigdata.java.io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamApp {

    public static void main(String[] args) {
        read();
    }

    private static void read() {
        FileInputStream inputStream = null;
        try {
            // 创建文件 input 字节流
            inputStream = new FileInputStream("java-basic/data/wc.data");
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                String res = new String(buffer, 0, length);
                System.out.println(res);
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
        }
    }
}