//装饰者模式

abstract class Girl {
    String description = "no particular";

    public String getDescription(){
        return description;
    }	
}

//美国女孩
class AmericanGirl extends Girl {
	public AmericanGirl() {
		description = "+AmericanGirl";
	}
}

//国产妹子
class ChineseGirl extends Girl {
	public ChineseGirl() {
		description = "+ChineseGirl";
	}
}

//装饰者
abstract class GirlDecorator extends Girl {
	public abstract String getDescription();
}

//下面以美国女孩示例
//给美国女孩加上金发
class GoldenHair extends GirlDecorator {
    private Girl girl;

    public GoldenHair(Girl g) {
        girl = g;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + "+with golden hair";
    }	
}

//加上身材高大的特性
class Tall extends GirlDecorator {
    private Girl girl;

    public Tall(Girl g) {
        girl = g;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + "+is very tall";
    }	
}

public class DecoratorTest {

	public static void main(String[] args) {
        Girl g1 = new AmericanGirl();
        System.out.println(g1.getDescription());

        GoldenHair g2 = new GoldenHair(g1);
        System.out.println(g2.getDescription());

        Tall g3 = new Tall(g2);
        System.out.println(g3.getDescription());
	}

}
