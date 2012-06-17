package com.ludo.lan.testwysylania;

import java.io.Serializable;

public class TestObject implements Serializable{
	
	private int value;
	private String name;
	public TestObject(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	public String toString(){
		return "Imie: " + name + " , wartość: " + value;
	}
}
