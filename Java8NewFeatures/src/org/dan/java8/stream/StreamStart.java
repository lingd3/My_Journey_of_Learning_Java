package org.dan.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamStart {
	
	public static void main(String[] args) {
		learnStream();
	}

	private static void learnStream() {
		// 首先创建一个1-6乱序的List
		List<Integer> lists = new ArrayList<>();
		lists.add(4);
		lists.add(3);
		lists.add(6);
		lists.add(1);
		lists.add(5);
		lists.add(2);

		// 看看List里面的数据是什么
		System.out.print("List里面的数据：");
		for (Integer elem : lists) {
			System.out.print(elem + " ");
		}
		System.out.println();

		// 最小值
		System.out.print("List中最小的值为:");
		Stream<Integer> stream = lists.stream();
		Optional<Integer> min = stream.min(Integer::compareTo);
		if (min.isPresent()) {
			System.out.println(min.get());
		}

		// 最大值
		System.out.print("List中最大的值为:");
		lists.stream().max(Integer::compareTo).ifPresent(System.out::print);
		System.out.println();

		// 排序

		System.out.print("将List流进行排序:");
		Stream<Integer> sorted = lists.stream().sorted();
		sorted.forEach(elem -> System.out.print(elem + " "));
		System.out.println();

		// 过滤
		System.out.print("过滤List流,只剩下那些大于3的元素:");
		lists.stream().filter(elem -> elem > 3).forEach(elem -> System.out.print(elem + " "));
		System.out.println();
		
		System.out.print("过滤List流,只剩下那些大于0并且小于4的元素:");
		lists.stream().filter(elem -> elem > 0)
					  .filter(elem -> elem < 4)
					  .sorted(Integer::compareTo)
					  .forEach(System.out::println);

		// 看看List里面的值有没有改变
		System.out.print("List里面的数据：");
		for (Integer elem : lists) {
			System.out.print(elem + " ");
		}
		
	}

}
