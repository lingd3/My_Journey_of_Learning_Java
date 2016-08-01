// 工厂模式之抽象工厂模式

//抽象工厂
interface KitchenFactory {
	public Food getFood();
	public TableWare getTableWare();
}

//抽象食物
interface Food {
	public String getFoodName();
}

//抽象餐具
interface TableWare {
	public String getToolName();
}

//以具体工厂AKitchen为例
class AKitchen implements KitchenFactory {
	public Food getFood() {
		return new Apple();
	}
	
    public TableWare getTableWare() {
        return new Knife();
     }	
}

//具体食物 Apple 的定义如下
class Apple implements Food{
	public String getFoodName() {
		return "apple";
	}
}

//具体餐具 Knife 的定义如下
class Knife implements TableWare { 
	public String getToolName() {
		return "knife";
	}
}

public class Foodaholic {

    public void eat(KitchenFactory k) {
        System.out.println("A foodaholic is eating "+ k.getFood().getFoodName()
               + " with " + k.getTableWare().getToolName() );
    }

    public static void main(String[] args) {
        Foodaholic fh = new Foodaholic();
        KitchenFactory kf = new AKitchen();
        fh.eat(kf);
    }

}
