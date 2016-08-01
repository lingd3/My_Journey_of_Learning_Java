// 工厂模式之工厂方法模式

import java.io.IOException;

// 抽象产品
abstract class Human2 {
    public abstract void Eat();
    public abstract void Sleep();
    public abstract void Beat();
}

// 具体产品-男人
class Man2 extends Human2 {
    public void Eat() {
        System.out.println("Man can eat.");        
    }

    public void Sleep() {
        System.out.println("Man can sleep.");
    }

    public void Beat() {
        System.out.println("Man can beat doudou.");        
    }

}

// 具体产品-女人
class Female2 extends Human2 {

    public void Eat() {
        System.out.println("Female can eat.");   
    }

    public void Sleep() {
        System.out.println("Female can sleep.");
    }

    public void Beat() {
        System.out.println("Female can beat doudou.");        
    }

}

//简单工厂变为了抽象工厂
abstract class HumanFactory2 {
	public abstract Human2 createHuman(String gender) throws IOException;
}

//具体工厂（每个具体工厂负责一个具体产品）  
class ManFactory extends HumanFactory2 {  
	public Human2 createHuman(String gender) throws IOException {  
	    return new Man2();  
	}  
}  
class FemaleFactory extends HumanFactory2 {  
	public Human2 createHuman(String gender) throws IOException {  
	    return new Female2();  
	}  
}  

//女娲造人
public class Goddess2 {  
	public static void main(String[] args) throws IOException {  
	    // 造个男人  
	    HumanFactory2 hf = new ManFactory();
	    Human2 h = hf.createHuman("man");
	    h.Eat();
	    h.Sleep();
	    h.Beat();
	} 
}