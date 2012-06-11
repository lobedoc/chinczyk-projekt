package com.ludo.observers;

public interface ServerSubject {
	
	public void registerObserver(ServerObserver o);
	public void removeObserver(ServerObserver o);
	public void notifyObservers();
}
