package com.ludo.lan.observer;

public interface ServerSubject {

	public void registerObserver(ServerObserver o);
	public void notifyObserver();
}
