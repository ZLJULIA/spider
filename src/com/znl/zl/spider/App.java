package com.znl.zl.spider;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ��������
 * @author julia
 * 
 */

public class App {
	
   //main+alt+/

	public static void main(String[] args) {
		
		  //�̳߳�
		  //�̶���С
		 ExecutorService pool=Executors.newFixedThreadPool(4);
		 //���ߣ����棩
		 pool=Executors.newCachedThreadPool();
//		 //һ���߳�
//		 pool=Executors.newSingleThreadExecutor();
	     ArrayList<Film> list=new ArrayList();
	     String url="https://movie.douban.com/top250?start";
		 for(int i=1;i<=100;i++){
			 String path=String.format("%s=%d", url,i*25);
			 pool.submit(new Spider(path,list)); 
		 }
		
		

	}

}
