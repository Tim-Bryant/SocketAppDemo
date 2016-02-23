package com.socket.ideal.socketlogin;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket协议通信，实现用户登录 服务器端
 * 
 * @author liuxf
 * 
 */
public class Server {

	public static void main(String[] args) {
		try {
			// 1 创建一个服务端的Serversocket，指定绑定端口，并监听端口
			ServerSocket serverSocket = new ServerSocket(8888);
			// 2 需要调用accept方法等待客户端连接
			System.out.println("***服务器即将启动，等待客户端连接***");
			//记录客户端数量
			int count=0;
			Socket socket =null;
			//循环监听等待客户端连接
			while(true){
				//调用accept()方法开始监听，等待客户端连接
				socket = serverSocket.accept();
				//创建一个新的线程
				ServerThread thread=new ServerThread(socket);
				//启动线程
				thread.start();
				count++;
				System.out.println("客户端数量为:"+count);
				InetAddress address1=socket.getInetAddress();
				System.out.println("当前客户端ip:"+address1.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
