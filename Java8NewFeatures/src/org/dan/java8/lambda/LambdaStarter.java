package org.dan.java8.lambda;

public class LambdaStarter {
	
	public static void main(String args[]) {
		LambdaStarter starter = new LambdaStarter();
		// �������������ı��ʽ
		MathOperation addition = (int a, int b) -> a + b;

		// û�����������ı��ʽ
		MathOperation subtraction = (a, b) -> a - b;

		// ���д����š����з������ı��ʽ
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// û�д����ź�return���ı��ʽ
		MathOperation division = (int a, int b) -> a / b;

		// ������
		System.out.println("10 + 5 = " + starter.operate(10, 5, addition));
		System.out.println("10 - 5 = " + starter.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + starter.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + starter.operate(10, 5, division));

		// û�����ŵı��ʽ
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// �����ŵı��ʽ
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		// ����sayMessage����������
		greetService1.sayMessage("Gordan");
		greetService2.sayMessage("God");
	}

	// �����Ƕ����һЩ�ӿںͷ���
	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
