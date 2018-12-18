package com.znl.zl.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * ץȡҳ����ӰƬ��Ϣ�����棨����
 * @author julia
 */

public class Spider implements Runnable {
	
	/*
	 * ҳ��·��(URL)
	 */
	String url;
	/*
	 * �洢ץȡ������
	 */
	ArrayList<Film> list;
	/*
	 * ��������
	 * url��ҳ���·��
	 * list���洢���ݵ��б�
	 */
	

	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}


	@Override
	public void run() {
		//���ִ�и�������̵߳�����
		String name=Thread.currentThread().getName();
		System.out.println(name+"�̣߳�����"+url);
		//JSOUP
		try {
			Document doc= Jsoup.connect(url).get();
			
			//���ĵ����������ҽڵ�
			Elements es=doc.select(".grid_view .item");
			
			//����Ԫ���б�
			for(Element e :es){
				Film f=new Film();
				
				//ÿһ��ӰƬ����Ϣ
				
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().attr("src");
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0,num.length()-3));
				f.quote=e.select(".inq").first().text();
				
				list.add(f);
				//System.out.println(name+":"+f);
			}
			System.out.println(name+"�̣߳����"+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
