package com.xk.bigdata.java.io.socket;

import com.xk.bigdata.java.utils.FinalCode;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        try {
            // 创建与服务端的连接
            socket = new Socket(FinalCode.HOSTNAME, FinalCode.PORT);
            System.out.println("客户端HOSTNAME:" + FinalCode.HOSTNAME + "  PORT:" + FinalCode.PORT + "已经创建连接");
            // 创建IO相关的socket流

            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                // 从控制台读取数据
                String requestMessage = console.readLine();
                writer.write(requestMessage + "\n");
                writer.flush();
                System.out.println("发送给服务端数据：" + requestMessage);
                String responseMessage = reader.readLine();
                System.out.println("responseMessage ：" + responseMessage);
                // 客户端是否退出
                if (FinalCode.EXIT.equalsIgnoreCase(requestMessage)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                    System.out.println("客户端HOSTNAME:" + FinalCode.HOSTNAME + "  PORT:" + FinalCode.PORT + "已经关闭连接");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
