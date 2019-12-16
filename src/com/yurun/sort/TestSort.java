package com.yurun.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestSort {
	
	private List<MyUser> userList=Arrays.asList(
			new MyUser("James", 35, "1"),
			new MyUser("��Ϫ", 22, "2"),
			new MyUser("Kobe", 38, "3"),
			new MyUser("Durant", 22, "4")
			);
	
	@Test
	public void testNatureSort() {
		System.out.println("����ǰ");
		userList.forEach(System.out::println);
		System.out.println("�����");
		
	/*	userList.sort(new Comparator<MyUser>() {
			@Override
			public int compare(MyUser o1, MyUser o2) {
				//1����
				return o1.getAge()-o2.getAge();
			}
		});*/
		//ʹ�� �������Ȼ����
		Collections.sort(userList);
		userList.forEach(System.out::println);
	}
	
	
	
	@Test
	public void testCompartor() {
		//comparing ָ�� ���� �ֶΣ��ᰴ���ֶεĽ�����Ȼ���� ����ʵ������ӿ�
		//Comparator �ӿ� ��Ѱ�� �������  �� CompareTo ���������� ��Ҫ ʵ�� comparable �ӿ�
		userList.sort(Comparator.comparing(MyUser::getAge));
		System.err.println(userList);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
