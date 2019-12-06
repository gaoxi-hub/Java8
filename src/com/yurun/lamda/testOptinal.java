package com.yurun.lamda;

import java.util.Optional;

import org.junit.Test;

import com.yurun.inteface.MyInterface;

public class testOptinal {
	/** 
	 *	1.����Optional�����Ĵ���
	 */
	@Test
	public void testCreateOptional() {
		Employee employee = new Employee();
		//1.�����ǷǿյĶ���
		Optional<Employee> of = Optional.of(employee);
		try {
			Optional.of(null);
		} catch (Exception e) {
			System.out.println(".of �����Է���null");
		}
		//2.����һ���յ�Optional
		Optional<Employee> empty = Optional.empty();
		//3.����һ�����Է���յ�Optinal
		Optional<Employee> ofNullable = Optional.ofNullable(null);
	}
	
	/** 
	 * 2.��ȡ�����е�����
	 */
	@Test
	public void testGetOptional() {
		Optional<Employee> ofNullable = Optional.ofNullable(null);
		try {
			Employee employee = ofNullable.get();	
		}catch (Exception e) {
			System.out.println("get��������Ԫ��Ϊnull,�ͱ���");
		}
		//orElseGet ֻ�������˸� ���Դ��� Supplier
		Employee orElseGet = ofNullable.orElseGet(()->new Employee("Ϊnull����"));
		Employee orElse = ofNullable.orElse(new Employee());
		System.out.println("orElseGet"+":"+orElseGet);
		System.out.println("orElse"+":"+orElse);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
