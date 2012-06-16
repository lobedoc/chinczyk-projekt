package com.ludo.lan.head;

public class HeadButton implements Head{

	private boolean e = true;
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0x1;
	}

	@Override
	public void setEnabled(boolean e) {
		// TODO Auto-generated method stub
		this.e = e;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return e;
	}
	
}
