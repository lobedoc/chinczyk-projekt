package com.ludo.lan.task;

public abstract class Task implements Runnable{

	private boolean stop;
	
	public Task(){
		stop  = false;
	}

	public void stop(){
		stop = true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop){
			task();
		}
		
	}
	
	public abstract void task();
	
}
