package com.dkl.thread.example;

class Info {

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  int getAge() {
		return age;
	}

	public  void setAge(int age) {
		this.age = age;
	}
	public synchronized void set(String name,int age){
		if(!flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name;
		this.age = age;
		flag = false;
		super.notifyAll();
	}
	public synchronized void get(){
		if(flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName()+"<---->"+this.getAge());
		flag = true;
		super.notifyAll();
	}
	private String name = "Rollen";
	private int age = 20;
	private boolean flag = false;
}

/**
 * 生产者
 * */
class Producer implements Runnable {
	private Info info = null;

	Producer(Info info) {
		this.info = info;
	}

	public  void run() {
		boolean flag = false;
		for (int i = 0; i < 20; ++i) {
				if (flag) {
					this.info.set("Rollen",20);
					flag = false;
				} else {
					this.info.set("chunGe",100);
				}
		}
	}
}

/**
 * 消费者类
 * */
class Consumer implements Runnable {
	private Info info = null;

	public Consumer(Info info) {
		this.info = info;
	}

	public  void run() {
		for (int i = 0; i < 20; ++i) {
			this.info.get();
			}
	}
}

public class Hello implements Runnable {
	public void run() {
		for (int i = 0; i < 10; ++i) {
			synchronized (this) {

				if (count > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " "
							+ count--);
				}
			}
		}
	}

	
	public static void main(String[] args) {
		// Hello he = new Hello();
		// Thread h1 = new Thread(he);
		// Thread h2 = new Thread(he);
		// Thread h3 = new Thread(he);
		// h1.start();
		// h2.start();
		// h3.start();
		Info info = new Info();
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		new Thread(pro).start();
		new Thread(con).start();
	}

	private int count = 5;
}
