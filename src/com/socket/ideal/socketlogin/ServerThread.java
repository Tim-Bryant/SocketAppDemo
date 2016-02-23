package com.socket.ideal.socketlogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * 
 * @author liuxf
 * 
 */
public class ServerThread extends Thread {

	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，相应客户端的请求
	public void run() {
		// 3获取输入流，用来读取客户端发送的信息
		InputStream is = null;
		// 字节流转化为字符流提高效率
		InputStreamReader reader = null;
		BufferedReader bufferedReader = null;
		OutputStream os = null;
		PrintWriter pWriter = null;
		try {
			is = socket.getInputStream();
			reader = new InputStreamReader(is);
			// 为输入流添加缓冲
			bufferedReader = new BufferedReader(reader);
			String info = null;
			while ((info = bufferedReader.readLine()) != null) {
				System.out.println("我是服务器，客户端说：" + info);

			}
			socket.shutdownInput();
			// 获取输入流相应客户端请求
			os = socket.getOutputStream();
			pWriter = new PrintWriter(os);
			pWriter.write("欢迎使用");
			pWriter.flush();// 调用flush方法将缓冲输出
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pWriter != null) {
					pWriter.close();
				}
				if (os != null) {
					os.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (is != null) {
					is.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
