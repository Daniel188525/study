package com.siebre.mvctest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8090/study/Policy/ProcessPartnerTransaction.jspx");
		HttpURLConnection g_URLConnection = (HttpURLConnection) url.openConnection();
	    g_URLConnection.setRequestProperty("content-type", "text/html;charset=utf-8");  
	    g_URLConnection.setDoOutput(true);
	    g_URLConnection.setDoInput(true);
		
	    FileInputStream fis = new FileInputStream("D:/YBT.xml");
		String byteTemp = fis.toString();
	    //生成输出流对象
	    OutputStream v_OutputStream = g_URLConnection.getOutputStream();
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    //写入文件内容
	    int x = 0;
	    while((x = fis.read()) != -1){
	      bos.write(x);
	    }
	    fis.close();

	    System.out.println(new String(bos.toByteArray()));
	    String s = new String(bos.toByteArray());
	    byte[] bytes = s.getBytes();
	    System.out.println(s);
	    
	    v_OutputStream.write(bytes);
	    //刷新输出流
	    v_OutputStream.flush();
    	int code = g_URLConnection.getResponseCode();
     	System.out.println("code   " + code);		


	    //获得服务器相应的输入流
	    InputStream g_return = g_URLConnection.getInputStream();
	    ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
	    while ((x = g_return.read()) != -1) {
	    	bos2.write(x);
	    }
	    bos2.flush();
	    //关闭URL
	    v_OutputStream.close();
	    g_return.close();
	    String str = new String(bos2.toByteArray());
	    System.out.println(str);
	    System.out.println(str);
		
	}
}
