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

	public static void main(String[] args) {
	//������Ҫץȡ��·����Ŀ��URL	
		String url="https://movie.douban.com/top250";
	//ʹ��JSOUP ץȡ�ĵ�
		try {
			Document doc=Jsoup.connect(url).get();
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//����һ��ӰƬ���б�
			ArrayList<Film> list=new ArrayList();
			
			for(Element e :es){
				Film f=new Film();
				
				//ÿһ��ӰƬ������
				
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().attr("src");
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0,num.length()-3));
				f.quote=e.select(".inq").first().text();
//				
				list.add(f);
				System.out.println(f);
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

}
