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
		// ���ȴ���һ��1-6�����List
		List<Integer> lists = new ArrayList<>();
		lists.add(4);
		lists.add(3);
		lists.add(6);
		lists.add(1);
		lists.add(5);
		lists.add(2);

		// ����List�����������ʲô
		System.out.print("List��������ݣ�");
		for (Integer elem : lists) {
			System.out.print(elem + " ");
		}
		System.out.println();

		// ��Сֵ
		System.out.print("List����С��ֵΪ:");
		Stream<Integer> stream = lists.stream();
		Optional<Integer> min = stream.min(Integer::compareTo);
		if (min.isPresent()) {
			System.out.println(min.get());
		}

		// ���ֵ
		System.out.print("List������ֵΪ:");
		lists.stream().max(Integer::compareTo).ifPresent(System.out::print);
		System.out.println();

		// ����

		System.out.print("��List����������:");
		Stream<Integer> sorted = lists.stream().sorted();
		sorted.forEach(elem -> System.out.print(elem + " "));
		System.out.println();

		// ����
		System.out.print("����List��,ֻʣ����Щ����3��Ԫ��:");
		lists.stream().filter(elem -> elem > 3).forEach(elem -> System.out.print(elem + " "));
		System.out.println();
		
		System.out.print("����List��,ֻʣ����Щ����0����С��4��Ԫ��:");
		lists.stream().filter(elem -> elem > 0)
					  .filter(elem -> elem < 4)
					  .sorted(Integer::compareTo)
					  .forEach(System.out::println);

		// ����List�����ֵ��û�иı�
		System.out.print("List��������ݣ�");
		for (Integer elem : lists) {
			System.out.print(elem + " ");
		}
		
	}

}
