package com.socket.ideal.socketlogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @author liuxf
 * 
 */
public class Client {
	public static void main(String[] args) {

		try {
			//1.客户端创建Socket，指定服务器地址和端口
			Socket socket=new Socket("127.0.0.1", 8888);
			//2.获取输出流，用来向服务器发送信息
			OutputStream os = socket.getOutputStream();
			//将输出流包装为打印流
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名:admin;密码:123");
			pw.flush();
			
			socket.shutdownOutput();//关闭输出流
			
			//获取输入流，读取服务端相应
			
			InputStream is = socket.getInputStream();
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader bufferedReader=new BufferedReader(reader);
			String backmessage=null;
			while((backmessage=bufferedReader.readLine())!=null){
				System.out.println("服务端说:"+backmessage);
			}
			bufferedReader.close();
			reader.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
