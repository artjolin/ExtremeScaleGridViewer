package com.shawnhurley;

public class Foo {
	private int hello = 12;
	private String hw = "Hello World";
	private Bar bar = new Bar();
	public int getHello() {
		return hello;
	}
	public void setHello(int hello){
		this.hello = hello;
	}
	public String getHw(){
		return hw;
	}
	public void setHw(String hw){
		this.hw = hw;
	}
	public Bar getBar(){
		return bar;
	}
	public void setBar(Bar bar){
		this.bar = bar;
	}
}
