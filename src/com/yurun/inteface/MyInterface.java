package com.yurun.inteface;

public interface MyInterface {
	
	
	default void sayWhat() {
		System.out.print("nihao");
	}
	
	static void sayHello() {
		System.out.println("HelloWorld");
	}
	
	

}
