package com.dkl.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime
//				.getRuntime().availableProcessors());
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
		ScheduledExecutorService scheduledThredaPool = Executors
				.newScheduledThreadPool(5);
		// for (int i = 0; i < 10; i++) {
		// final int index = i;
		// try {
		// Thread.sleep(index * 1);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// cachedThreadPool.execute(new Runnable() {
		// public void run() {
		// System.out.println(index);
		// }
		// });
		// }

//		 cachedThreadPool.shutdown();
		 for(int i = 0;i<1000;i++){
		 final int index = i;
		
		 fixedThreadPool.execute(new Runnable(){
		 public void run(){
		 System.out.println(Thread.currentThread()+":"+index);
		 }
		 });
		 }
		fixedThreadPool.shutdown();
//		scheduledThredaPool.schedule(new Runnable() {
//			public void run() {
//				System.out.println("delay 3 seconds");
//			}
//		}, 2, TimeUnit.SECONDS);
//		scheduledThredaPool.scheduleAtFixedRate(new Runnable() {
//			public void run() {
//				System.out.println("delay 3 seconds");
//			}
//		}, 0, 2, TimeUnit.SECONDS);
//		for(int i = 0; i< 10000;i++)
//			;
//		scheduledThredaPool.shutdown();
	}

}