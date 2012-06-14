package com.ludo.app.observer;

public interface PawnSubject {

	public void registerObserver(PawnObserver o);
	public void notifyObserver();
	public void removeObserver(PawnObserver o);
}
