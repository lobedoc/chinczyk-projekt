package com.ludo.lan.head;

import java.io.Serializable;

public interface Head extends Serializable{
	
	public int getID();
	public Object getObject();
	public void setObject(Object o);
}
