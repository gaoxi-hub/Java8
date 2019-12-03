package com.yurun.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamDemo {
	/** 
	 * 1.创建流的五种方式
	 * 	集合.stream() 常用
	 * 	Arrays.stream(arr);
	 * 	Stream类：Stream.of();Stream.iteator() /.generate()
	 * 
	 */
	@Test
	public void testCreateStream() {
		//1.将数组转换成流，进行forEach打印
		String[] array= {"Hello","World","你好","世界"};
		Arrays.stream(array).forEach(System.out::println);
		//2.将集合转换成流,进行 count计数
		List<String> list=Arrays.asList(array);
		long count = list.stream().count();
		System.out.println(count);
		//Stream.of
		long count2 = Stream.of(array).count();
		System.out.println(count2);
		//Stream.iteator生成 ,从0开始无限生成数字
		Stream.iterate(0, (x) -> x+1).forEach(System.out::println);
		//Stream.generate()
		Stream.generate(()-> 1).forEach(System.out::println);
	}
	
	
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(204, "赵六", 8, 7777.77),
			new Employee(304, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	/** 
	 * 1.测试Filter
	 */
	@Test
	public void testFilter() {
		Stream<Employee> stream = emps.stream();
		stream.filter((x)->x.getAge()>10).forEach(System.out::println);
	}
	
	/** 
	 * 2.distinct()
	 */
	@Test
	public void testDistinct() {
		Stream<Employee> stream = emps.stream();
		stream.distinct().forEach(System.out::println);
	}
	
	/** 
	 * 3.limit()
	 */
	@Test
	public void testLimit() {
		Stream<Employee> stream = emps.stream();
		stream.limit(3).forEach(System.out::println);
	}
	
	/** 
	 * 4.skip() :跳过前n个元素
	 */
	@Test
	public void testSkip() {
		Stream<Employee> stream = emps.stream();
		stream.skip(3).forEach(System.out::println);
	}
	
	/** 
	 * 1.map
	 * 
	 */
	@Test
	public void testMap() {
		Stream<Employee> stream = emps.stream();
		Stream<String> map = stream.map((emp)->emp.getName());
		map.forEach(System.out::println);
	}
	
	/** 
	 * 2.flatMap
	 */
	@Test
	public void testFlatMap() {
		Stream<Employee> stream = emps.stream();
		Stream<String> flatMap = stream.flatMap((emp) ->  Stream.of(emp.getName()));
		flatMap.forEach(System.out::println);
	}
	
	/** 
	 * 3.mapToxxxx
	 *   	返回xxxStream
	 */
	@Test
	public void testMapToInt() {
		Stream<Employee> stream = emps.stream();
		IntStream mapToInt = stream.mapToInt((emp)->emp.getAge());
		mapToInt.forEach(System.out::println);
	}
	
	/** 
	 * 1.sort() 自然排序
	 */
	@Test
	public void testNatureSort() {
		int[] arr= {5,64,3,1,6,4,8,0,342,324234};
		IntStream stream = Arrays.stream(arr);
		IntStream sorted = stream.sorted();
		sorted.forEach(System.out::println);
	}
	
	/** 
	 * 2.sort(Coparetor) 定制排序 
	 * 0 -1 变位置
	 */
	@Test
	public void testSpecifiedSort() {
		emps.stream()
			.sorted((x,y)-> x.getAge()-y.getAge())
			.forEach(System.out::println);
	}
	
	/** 
	 * 1.测试max
	 */
	@Test
	public void testMax() {
		Optional<Employee> max = emps.stream()
			.max((x,y)-> x.getAge()-y.getAge());
		System.out.println(max.get());
	}
	
	
	/** 
	 * findAny
	 */
	@Test
	public void testFindAny() {
		Optional<Employee> findAny = emps.parallelStream().findAny();
		System.out.println(findAny.get());
	}
	
	/** 
	 * allMatch
	 */
	@Test
	public void testAllMatch() {
		boolean allMatch = emps.stream().noneMatch((x)->x.getAge()>99);
		System.out.println(allMatch);
	}
	
	/** 
	 * reduce
	 */
	@Test
	public void testReduceNoArg() { 
		//单词拼接
		List<String> words=Arrays.asList("java","java","Spring","Spring",
				"cloud","hadoop","hive","hadoop","flume","kafka");
		//将流中元素规约 第一个元素 第二元素， 结果作为下一的x 第三个元素作为 y
		Optional<String> reduce = words.stream().reduce((x,y)-> x+y);
		String string = reduce.get();
		System.out.println(string);
		String reduce2 = words.stream().reduce(string,(x,y)-> x+"-"+y);
		System.out.println(reduce2);
	}
	
	
	/** 
	 * toList toSet
	 * 
	 */
	@Test
	public void testToListOrSet() {
		String[] array= {"java","java","Spring","Spring",
				"cloud","hadoop","hive","hadoop","flume","kafka"};
		Stream<String> stream = Arrays.stream(array);
		List<String> collect = stream.limit(5).collect(Collectors.toList());
		//一个流不能连续用两次 不然会报错
		Set<String> collect2 = stream.skip(5).collect(Collectors.toSet());
		System.out.println(collect);
		System.out.println(collect2);
	}
	
	
	/** 
	 *  变成特定的Set或List
	 *  
	 */
	@Test
	public void toArrayListOrHashSet() {
		String[] array= {"java","java","Spring","Spring",
				"cloud","hadoop","hive","hadoop","flume","kafka"};
		Stream<String> stream = Arrays.stream(array);
		ArrayList<String> collect = stream.limit(5).collect(Collectors.toCollection(ArrayList::new));
		//一个流不能连续用两次 不然会报错
		//	HashSet<String> collect2 = stream.skip(5).collect(Collectors.toCollection(HashSet::new));
		System.out.println(collect);
		//System.out.println(collect2);
	}
	
	/** 
	 * toMap
	 */
	@Test
	public void testToMap() {
		String[] array= {"Spring","Spring"};
		Stream<String> stream = Arrays.stream(array);
		//不可以有重复key
		Map<String, Integer> collect = stream.collect(Collectors.toMap((x)->x, (x)->x.hashCode()));
		System.out.println(collect);
	}
	
	/** 
	 * 1.joining的使用
	 */
	@Test
	public void testJoining() {
		String[] array= {"Spring","Spring","Java","Dubbo","Hallo","Durant"};
		Stream<String> stream = Arrays.stream(array);
		//不可以有重复key
		String collect = stream.collect(Collectors.joining("-", "===", "???"));
		
		System.out.println(collect);
	}
	
	/** 
	 * groupingby 
	 * 
	 */
	@Test
	public void testPatitionBy() {
		String[] array= {"java","java","Spring","Spring",
				"cloud","hadoop","hive","hadoop","flume","kafka"};
		//Map<Object, List<String>> collect = Arrays.stream(array).collect(Collectors.groupingBy((x)->x));
		Map<Boolean, List<String>> collect = Arrays.stream(array).collect(Collectors.partitioningBy((x)-> x.equals("java")));
		System.out.println(collect);
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
