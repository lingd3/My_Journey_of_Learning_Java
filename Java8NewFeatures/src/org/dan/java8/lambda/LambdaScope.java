package org.dan.java8.lambda;

public class LambdaScope {

	final static String salutation = "Hello "; // ��ȷ�������ٴθ�ֵ
//	 static String salutation = "Hello "; //��ȷ�����ٴθ�ֵ
//	 String salutation = "Hello "; //����
//	 final String salutation = "Hello "; //����

	public static void main(String args[]) {
//		 final String salutation = "Hello "; //��ȷ�������ٴθ�ֵ
//		 String salutation = "Hello "; //��ȷ������Ϊ final , �����ٴθ�ֵ

//		 salutation = "welcome to "; //���󣬱���Ϊfinal
		GreetingService greetService1 = message -> System.out.println(salutation + message);
		greetService1.sayMessage("Gordan");
	}

	interface GreetingService {
		void sayMessage(String message);
	}

}
