package Proxy;

/**
 * 目标对象实现接口
 */
public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("----已经保存数据----");
	}

}
