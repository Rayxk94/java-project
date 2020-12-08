package com.xk.bigdata.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InOutStreamApp {

    public static void main(String[] args) {
//        read();
        write();
    }

    private static void write() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("java-basic/data/wc.data");
            outputStream = new FileOutputStream("java-basic/out/wc.data");
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
