package com.yurun.lamda;

import java.util.Optional;

import org.junit.Test;

import com.yurun.inteface.MyInterface;

public class testOptinal {
	/** 
	 *	1.创建Optional容器的创建
	 */
	@Test
	public void testCreateOptional() {
		Employee employee = new Employee();
		//1.必须是非空的对象
		Optional<Employee> of = Optional.of(employee);
		try {
			Optional.of(null);
		} catch (Exception e) {
			System.out.println(".of 不可以放入null");
		}
		//2.创建一个空的Optional
		Optional<Employee> empty = Optional.empty();
		//3.创建一个可以放入空的Optinal
		Optional<Employee> ofNullable = Optional.ofNullable(null);
	}
	
	/** 
	 * 2.获取容器中的数据
	 */
	@Test
	public void testGetOptional() {
		Optional<Employee> ofNullable = Optional.ofNullable(null);
		try {
			Employee employee = ofNullable.get();	
		}catch (Exception e) {
			System.out.println("get方法，当元素为null,就报错");
		}
		//orElseGet 只不过多了个 可以传入 Supplier
		Employee orElseGet = ofNullable.orElseGet(()->new Employee("为null返回"));
		Employee orElse = ofNullable.orElse(new Employee());
		System.out.println("orElseGet"+":"+orElseGet);
		System.out.println("orElse"+":"+orElse);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
