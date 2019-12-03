package com.yurun.lamda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.security.auth.x500.X500Principal;

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
	public void testOriginal() {
		//1.�Զ���Ƚ���
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
	
	
	
	
	
	@Test
	public void testComputerLamda() {
		//����������
		Computer op=(x,y) -> x+y;
		int addTwoNum = computerTwoNum(1, 1, op);
		System.out.println(addTwoNum);
		//���������ĳ�
		System.out.println(computerTwoNum(1,1,(x,y) -> x*y));
		//���������Ĳ�
		System.out.println(computerTwoNum(1, 1, (x,y) -> x-y));
	}
	
	public int computerTwoNum(int x,int y,Computer op) {
		return op.computer(x, y);
	}
	interface Computer {
		int computer(int x,int y);
	}
	
	@FunctionalInterface
	interface myFuctionInterface{
		void hello();
	}
	
	
	@Test
	public void testConsumer() {
		Consumer<List<String>> consumer=(list) -> {
			for(String t:list) System.out.println(t);
		};
		consumer.accept(Arrays.asList("Hello","World"));
	}
	
	@Test
	public void testSupplier() {
		Supplier<String> supplier= () -> "HelloWorld";
		System.out.println(supplier.get());
	}
	
	
	
	@Test
	public void testFunctionInter() {
		Function<Integer, String> myFunction=(x)->{
			if(x>10) return "����10";
			else return "С�ڵ���10";
		};
		System.out.println(myFunction.apply(10));
	}
	@Test
	public void testPredict() {
		
		Predicate<String> predicate =(x) -> x.equals("HelloWorld");
		
		System.out.println(predicate.test("���Demo"));
	
	}
	
	@Test
	public void testSysOut() {
		Consumer<Integer> consumer=System.out::println;
		consumer.accept(12321);
	}
	
	@Test
	public void testEquals() {
		ClassMethod tClassMethod = String::equals;
		tClassMethod.compare("hello", "ddd");
	}
	@FunctionalInterface
	interface ClassMethod{
		void compare(String x,String y);
	}
	@Test
	public void testConstruct() {
		Function<String,Employee> function=Employee::new;
		Employee employee= function.apply("��Ϫ");
		System.out.println(employee);
	}
}
