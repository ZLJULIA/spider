package com.znl.zl.spider;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 程序的入口
 * @author julia
 * 
 */

public class App {
	
   //main+alt+/

	public static void main(String[] args) {
		
		  //线程池
		  //固定大小
		 ExecutorService pool=Executors.newFixedThreadPool(4);
		 //无线（缓存）
		 pool=Executors.newCachedThreadPool();
//		 //一个线程
//		 pool=Executors.newSingleThreadExecutor();
	     ArrayList<Film> list=new ArrayList();
	     String url="https://movie.douban.com/top250?start";
		 for(int i=1;i<=100;i++){
			 String path=String.format("%s=%d", url,i*25);
			 pool.submit(new Spider(path,list)); 
		 }
		
		

	}

}
