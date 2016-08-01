class Animal {
    public Animal(){
        System.out.println("我是动物");
    }
}

class Dog extends Animal {
    public Dog(){
        System.out.println("我是狗");
    }
}


public class Test_Generics {

	/*
	*注意：定义带类型参数的方法，其主要目的是为了表达多个参数以及返回值之间的关系。例如本例子中T和S的继承关系， 返回值的类型和第一个类型参数的值相同。
	*/
    public<T, S extends T> T testDemo(T t, S s){
        System.out.println("我是 T 类型，我的类型是" + s.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + t.getClass().getName());
        return t;
    }
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	    	Test_Generics test = new Test_Generics();
	        Dog d = new Dog();
	        Animal a0 = new Animal();
	        Animal a1  = test.testDemo(a0, d);
	        System.out.println("我是整数 a，我的类型是" + a1.getClass().getName());
	    }

}
