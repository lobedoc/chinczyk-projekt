package com.ludo.lan.task;

public abstract class Task implements Runnable{

	private boolean stop;
	
	public Task(){

	}

	public void stop(){
		stop = true;
	}
	@Override
	public void run() {
		stop  = false;
		// TODO Auto-generated method stub
		taskStream();
		while(!stop){
			task();
		}
		
	}
	
	protected abstract void task();
	protected void taskStream(){
		
	}
}
