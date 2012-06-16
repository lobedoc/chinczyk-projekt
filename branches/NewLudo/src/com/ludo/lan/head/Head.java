package com.ludo.lan.head;

import java.io.Serializable;

public interface Head extends Serializable{
	
	public int getID();
	public void setEnabled(boolean e);
	public boolean isEnabled();
}
