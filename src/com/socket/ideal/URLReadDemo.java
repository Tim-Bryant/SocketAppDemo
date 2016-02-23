package com.socket.ideal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取网页内容
 * 
 * @author liuxf
 * 
 */
public class URLReadDemo {
	public static void main(String[] args) {
       try {
		URL url=new URL("http://www.baidu.com");
		//通过URL的openStream方法，获得URL对象所表示的资源的字节输入流
		InputStream is = url.openStream();
		//将字节输入流转化为字符输入流
		InputStreamReader reader=new InputStreamReader(is,"UTF-8");
		//为字符输入流添加缓冲,提高读取效率
		BufferedReader bufferedReader=new BufferedReader(reader);
		//读取一行内容
		String data = bufferedReader.readLine();
		while(data!=null){
			System.out.println(data);
			data=bufferedReader.readLine();
		}
		bufferedReader.close();
		reader.close();
		is.close();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
