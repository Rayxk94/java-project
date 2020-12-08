package com.xk.bigdata.java.io.reader;

import java.io.FileReader;
import java.io.IOException;

public class ReaderApp {

    public static void main(String[] args) {
        read();
    }

    private static void read() {
        FileReader reader = null;
        try {
            // 创建一个字符流输入流
            reader = new FileReader("java-basic/data/wc.data");
            char[] buffle = new char[1024];
            int length = 0;
            while ((length = reader.read(buffle, 0, buffle.length)) != -1) {
                String result = new String(buffle, 0, length);
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}