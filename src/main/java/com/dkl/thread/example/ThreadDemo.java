package com.dkl.thread.example;

/*
 * 简单的售票系统   没有解决同步的问题，多次测试终于出现线了票数大于100的情况
 *创建线程，启动线程： 
 *ThreadDemo t = new ThreadDemo();
 *Thread t1 = new Thread(t);
 *t1.start();
 *【同步代码块】：

 语法格式：

 synchronized（同步对象）{

 //需要同步的代码

 }
 */

public class ThreadDemo implements Runnable {
	private int count = 100; // 票的总数
	private int i = 0; // 卖的第几张票

	public void run() {
//		try {
//			super.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		sale();
	}

	private  void sale() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this){
			while (count-- > 0) {
				System.out.println(Thread.currentThread().getName() + " " + ++i);
			}
			
		}
	}

	public static void main(String args[]) {
		ThreadDemo t = new ThreadDemo();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
