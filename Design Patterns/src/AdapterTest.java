//适配器模式

// 英标接口
interface EnPluginInterface {
	void chargeWith3Pins();
}

//实现英标接口的充电方法
class EnPlugin implements EnPluginInterface {
    public void chargeWith3Pins() {
        System.out.println("charge with EnPlugin");
    }	
}

//在室内充电
class Home {
    private EnPluginInterface enPlugin;

    public Home() { }

    public Home(EnPluginInterface enPlugin) {
        this.enPlugin = enPlugin;
    }

    public void setPlugin(EnPluginInterface enPlugin) {
        this.enPlugin = enPlugin;
    }

    // 充电
    public void charge() {
        enPlugin.chargeWith3Pins();
    }
}

//英标测试类
class Test {
    public static void main(String[] args) {
        EnPluginInterface enPlugin = new EnPlugin();
        Home home = new Home(enPlugin);

        // 会输出 “charge with EnPlugin”
        home.charge();
    }	
}

//现在你回内陆了，只能用国标充电
//国标接口
interface CnPluginInterface {
	void chargeWith2Pins();
}

//实现国标接口的充电方法
class CnPlugin implements CnPluginInterface {
	public void chargeWith2Pins() {
		System.out.println("charge with CnPlugin");
	}
}

//适配器
class PluginAdapter implements EnPluginInterface {
    private CnPluginInterface cnPlugin;

    public PluginAdapter(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }

    // 这是重点，适配器实现了英标的接口，然后重载英标的充电方法为国标的方法
    @Override
    public void chargeWith3Pins() {
        cnPlugin.chargeWith2Pins();
    }	
}

//适配器测试类
public class AdapterTest {

	public static void main(String[] args) {
        CnPluginInterface cnPlugin = new CnPlugin();
        Home home = new Home();
        PluginAdapter pluginAdapter = new PluginAdapter(cnPlugin);
        home.setPlugin(pluginAdapter);

        // 会输出 “charge with CnPlugin”
        home.charge();
	}

}
