package com.xk.bigdata.java.io.buffered;

import java.io.*;

public class BufferedWriterApp {

    public static void main(String[] args) {
        write();
    }

    private static void write() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("java-basic/out/wc.data")));
            writer.write("Hello World");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
