package com.znl.zl.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {
   public static void main(String[] args) {
	   //路徑
	   String url="https://movie.douban.com/subject/1292052/";
	   //JSOUP
	   try {
		Document doc=Jsoup.connect(url).get();
		//elemt+alt+/
		Elements es=doc.select("#info .attrs a");
		System.out.println(es.size());
		System.out.println(es.first().text());
//		ArrayList<Film2> list=new ArrayList();
//		for(Element e :es){
//			Film2 f=new Film2();
//			
//			//每一部影片的信息
//			
//		
//			f.director=e.select("span").first().attr("a");
//
////			
//			list.add(f);
//			System.out.println(f);
		
		
		
		
		
		
		
		
		
		
//		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
