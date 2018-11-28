package org.dan.java8.lambda;

public class LambdaScope {

	final static String salutation = "Hello "; // 正确，不可再次赋值
//	 static String salutation = "Hello "; //正确，可再次赋值
//	 String salutation = "Hello "; //报错
//	 final String salutation = "Hello "; //报错

	public static void main(String args[]) {
//		 final String salutation = "Hello "; //正确，不可再次赋值
//		 String salutation = "Hello "; //正确，隐性为 final , 不可再次赋值

//		 salutation = "welcome to "; //错误，必须为final
		GreetingService greetService1 = message -> System.out.println(salutation + message);
		greetService1.sayMessage("Gordan");
	}

	interface GreetingService {
		void sayMessage(String message);
	}

}
