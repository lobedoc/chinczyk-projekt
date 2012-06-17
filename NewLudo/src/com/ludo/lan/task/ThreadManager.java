package com.ludo.lan.task;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadManager {
	ArrayList<Task> taskList = new ArrayList<Task>();
	private ExecutorService executor = Executors.newCachedThreadPool();
	private static volatile ThreadManager manager;
	
	private ThreadManager(){}
	
	public static ThreadManager getInstance(){
		if(manager == null){
			synchronized(ThreadManager.class){
				if(manager == null){
					manager = new ThreadManager();
				}
			}
		}
		return manager;
	}
	
	public void execute(Task task){
		taskList.add(task);
		executor.execute(task);
	}
	public void shoutdownNow(){
		executor.shutdownNow();
	}
}