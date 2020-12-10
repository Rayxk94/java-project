package com.xk.bigdata.java.io.socket;

import com.xk.bigdata.java.utils.FinalCode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 创建socket server
            serverSocket = new ServerSocket(FinalCode.PORT);
            System.out.println("Socket Server 已经创建，端口是：" + FinalCode.PORT);
            while (true) {
                // 创建接受客户端发送数据的Socket
                Socket socket = serverSocket.accept();
                System.out.println("端口为：" + socket.getPort() + "的客户端已经创建连接");
                // 创建IO流
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String message = null;
                while ((message = reader.readLine()) != null) {
                    if (null != message) {
                        System.out.println("客户端发送过来的数据：" + message);
                        writer.write("-----------------" + message + "\n");
                        writer.flush();
                        if (FinalCode.EXIT.equalsIgnoreCase(message)) {
                            System.out.println("客户端【" + socket.getPort() + "】 已经退出");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                    System.out.println("Socket Server 已经关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
