package com.xk.bigdata.java.io.buffered;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReaderApp {

    public static void main(String[] args) {
        read();
    }

    private static void read() {
        BufferedReader reader = null;
        String result = null;
        try {
            // 创建一个字节流转字符流的读取数据流
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("java-basic/data/wc.data")));
            while ((result = reader.readLine()) != null){
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
