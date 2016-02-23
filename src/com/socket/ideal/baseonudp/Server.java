package com.socket.ideal.baseonudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 基于UDP的服务端,实现用户登录
 * 
 * @author liuxf
 * 
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * 服务器接受客户端
		 */
		//1.创建服务端的DatagramSocket 指定端口
		DatagramSocket datagramSocket=new DatagramSocket(8800);
		//2.创建数据报，用于接收客户端发送的信息
		byte[] data=new byte[1024];
		DatagramPacket datagramPacket=new DatagramPacket(data, data.length);
		//3.接受客户端发送的数据
		System.out.println("服务器已经启动，等待客户端发送数据...");
		datagramSocket.receive(datagramPacket);//此方法在接收到数据报之前，一直阻塞
		//4.读取客户端的数据
		String info=new String(data, 0, datagramPacket.getLength());
		System.out.println("我是服务器，客户端说:"+info);
		
		/**
		 * 服务器向客户端相应
		 */
		//1.定义客户端地址，端口号，数据
		InetAddress address=datagramPacket.getAddress();
		int port = datagramPacket.getPort();
		byte[] data2="欢迎您使用".getBytes();
		//2.创建数据报，包含相应的信息
		DatagramPacket packet2=new DatagramPacket(data2, data2.length, address, port);
		//3.响应客户端
		datagramSocket.send(packet2);
		//4.关闭资源
		datagramSocket.close();
	}
}
