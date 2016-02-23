package com.socket.ideal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress 类
 * @author liuxf
 *
 */
public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {

		//获取本机InetAddress实例
		InetAddress inetAddress=InetAddress.getLocalHost();
		System.out.println("主机名:"+inetAddress.getHostName());
		System.out.println("ip地址："+inetAddress.getHostAddress());
		//直接获取字节数组的ip地址形式
		byte[] address = inetAddress.getAddress();
		System.out.println(Arrays.toString(address));
		System.out.println(inetAddress);
		
		//根据主机名获取In哦他Address实例
		InetAddress inetAddress2 = InetAddress.getByName("10.145.204.180");
		System.out.println("主机名:"+inetAddress2.getHostName());
		System.out.println("ip地址："+inetAddress2.getHostAddress());
		
	}
}
