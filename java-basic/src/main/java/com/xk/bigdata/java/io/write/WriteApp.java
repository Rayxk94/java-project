package com.xk.bigdata.java.io.write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteApp {

    public static void main(String[] args) {
        write();
    }

    private static void write() {
        FileWriter writer = null;
        try {
            // 创建一个字符输出流
            writer = new FileWriter("java-basic/out/wc.data");
            writer.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
