package com.yurun.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestSort {
	
	private List<MyUser> userList=Arrays.asList(
			new MyUser("James", 35, "1"),
			new MyUser("高溪", 22, "2"),
			new MyUser("Kobe", 38, "3"),
			new MyUser("Durant", 22, "4")
			);
	
	@Test
	public void testNatureSort() {
		System.out.println("排序前");
		userList.forEach(System.out::println);
		System.out.println("排序后");
		
	/*	userList.sort(new Comparator<MyUser>() {
			@Override
			public int compare(MyUser o1, MyUser o2) {
				//1交换
				return o1.getAge()-o2.getAge();
			}
		});*/
		//使用 对象的自然排序
		Collections.sort(userList);
		userList.forEach(System.out::println);
	}
	
	
	
	@Test
	public void testCompartor() {
		//comparing 指定 排序 字段，会按照字段的进行自然排序 必须实现排序接口
		//Comparator 接口 会寻找 排序对象  的 CompareTo 方法，所以 需要 实现 comparable 接口
		userList.sort(Comparator.comparing(MyUser::getAge));
		System.err.println(userList);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
