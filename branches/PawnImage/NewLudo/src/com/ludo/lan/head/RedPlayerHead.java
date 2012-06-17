package com.ludo.lan.head;

public class RedPlayerHead implements Head{
	private Object o;

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return HeadConst.redPlayer;
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return o;
	}

	@Override
	public void setObject(Object o) {
		// TODO Auto-generated method stub
		this.o = o;
	}

}
