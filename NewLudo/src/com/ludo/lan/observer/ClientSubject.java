package com.ludo.lan.observer;

public interface ClientSubject {
	
	public void registerObserver(ClientObserver o);
	public void notifyObserver();
}
