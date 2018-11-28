package org.dan.java8.optional;

import java.util.Optional;

public class OptionalStarter {

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {

		// isPresent ���ڼ��ֵ�Ƿ����
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// �����ǰ���ص��Ǵ����Ĭ��ֵ��orElse ��������
		Integer value1 = a.orElse(new Integer(0));

		// get ���ڻ��ֵ�����������ֵ�������
		Integer value2 = b.get();
		return value1 + value2;
	}

	public static void main(String[] args) {
		OptionalStarter starter = new OptionalStarter();
		Integer value1 = null;
		Integer value2 = new Integer(5);
		
		// ofNullable ������ʱ���� null
		Optional<Integer> a = Optional.ofNullable(value1);

		// ������ݵĲ���Ϊnull����ô of ���׳���ָ���쳣��NullPointerException��
		Optional<Integer> b = Optional.of(value2);
		System.out.println(starter.sum(a, b));

	}

}
