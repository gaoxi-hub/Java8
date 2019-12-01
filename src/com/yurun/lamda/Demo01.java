package com.yurun.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Predicate;

import org.junit.Test;

public class Demo01 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "����", 59, 6666.66),
			new Employee(101, "����", 18, 9999.99),
			new Employee(103, "����", 28, 3333.33),
			new Employee(104, "����", 8, 7777.77),
			new Employee(104, "����", 8, 7777.77),
			new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55)
	);
	
	
	@Test
	public void testStreamFilterAndSplit() {
		emps.stream().filter( (x) -> x.getAge()>18).forEach(System.out::println);;
		
	}
	
	
	
	
	
	
	
	@Test
	public void testOriginal() {
		//1.����һ���Ƚ���
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return Integer.compare(o1, o2);
			}
		};
		//2.����һ�����ȶ���
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(comparator);
		priorityQueue.add(2);
		priorityQueue.add(1);
		System.out.print(priorityQueue.peek());		
	}
	
	@Test
	public void testLamda() {
		//1.����һ���Ƚ���
		Comparator<Integer> comparator = (o1,o2) -> Integer.compare(o1, o2);
		//2.����һ�����ȶ���
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(comparator);
		priorityQueue.add(1);
		priorityQueue.add(2);
		System.out.print(priorityQueue.peek());		
	}
	
	
	
	
	
	

}
