// 工厂模式之简单工厂模式

import java.io.IOException;

//抽象产品
abstract class Human {
	public abstract void Eat();
	public abstract void Sleep();
	public abstract void Beat();
}

//具体产品-男人
class Man extends Human {
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

//具体产品-女人
class Female extends Human{

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

//简单工厂
class HumanFactory {
    public static Human createHuman(String gender){
        Human human = null;
        if( gender.equals("man") ){
            human = new Man();
        }else if( gender.equals("female")){
            human = new Female();
        }

        return human;
    }
}

// 女娲造人
public class Goddess {  
    public static void main(String[] args) throws IOException {  
        // 造个男人  
        Human human = HumanFactory.createHuman("man");  
        human.Eat();
        human.Sleep();
        human.Beat();
    } 
}
