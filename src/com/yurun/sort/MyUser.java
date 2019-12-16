package com.yurun.sort;

import java.io.Serializable;

public class MyUser  implements Comparable<MyUser>{
	private String name;
	private Integer age;
	private String userId;
	
	public MyUser(String name, Integer age, String userId) {
		super();
		this.name = name;
		this.age = age;
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "MyUser [name=" + name + ", age=" + age + ", userId=" + userId + "]";
	}
	
	//
	@Override
	public int compareTo(MyUser o) {
		
		return -(this.getAge()-o.getAge());
	}
	
	
	
	

	
}
