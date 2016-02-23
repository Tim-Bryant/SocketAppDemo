package com.socket.ideal;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 关于URL的常用方法
 * 
 * @author liuxf
 * 
 */
public class URLDemo {
	public static void main(String[] args) {
		// 创建一个URL实例
		try {
			URL imooc = new URL("http://www.imooc.com");
			/**
			 * ?表示参数  #表示的是锚点
			 */
			URL url = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			//如果未指定端口号，则根据使用默认端口号，此时getPort返回值为-1
			System.out.println("端口："+url.getPort());
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名："+url.getFile());
			//就是锚点
			System.out.println("相对路径："+url.getRef());
			//查询参数
			System.out.println("查询字符串："+url.getQuery());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
