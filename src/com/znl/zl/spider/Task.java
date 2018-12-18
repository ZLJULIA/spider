package com.znl.zl.spider;
//alt+/快捷键
/*
 * 定义一个可以交给线程去执行的任务
 * @author julia
 */
public class Task implements Runnable{
	//任务编号
	int n;
	

	public Task(int n) {
		super();
		this.n = n;
	}


	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println(name+"开始:"+n);
		//延时
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name+"结束:"+n);
	}
      
}
