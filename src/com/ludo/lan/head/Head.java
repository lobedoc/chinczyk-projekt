package com.ludo.lan.head;

import java.io.Serializable;

public abstract class Head implements Serializable{
	private Object o;
	public abstract int getID();
	public Object getObject(){
		return o;
	}
	public void setObject(Object o){
		this. o = o;
	}
}
