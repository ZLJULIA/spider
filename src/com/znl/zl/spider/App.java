package com.znl.zl.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * ��������
 * @author julia
 * 
 */

public class App {
	
   //main+alt+/
	private static final String Film = null;

	public static void main(String[] args) {
	//������Ҫץȡ��·����Ŀ��URL	
		String url="https://movie.douban.com/top250";
	//ʹ��JSOUP ץȡ�ĵ�
		try {
			Document doc=Jsoup.connect(url).get();
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//����һ��ӰƬ���б�
			ArrayList<Film> list = new ArrayList<>();
			
			for(Element e :es){
				Film f=new Film();
				
				//ÿһ��ӰƬ������
				Element t=e.select(".title").first();
				String num=e.select(".star span").last().text();
				System.out.println(t.text()+","+num);
				
				//f.id
				//f.title
				list.add(f);
			}
//			String title=doc.title();
//			String data=doc.data();
			
			//syso+alt+/
//			System.out.println(title);
//			System.out.println(data);
			
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ArrayList(String film2) {
		// TODO Auto-generated method stub
		
	}
}
