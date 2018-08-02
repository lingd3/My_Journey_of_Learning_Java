package Proxy;

/**
 * 静态代理对象
 *
 */
public class UserDaoProxy implements IUserDao {

	//接收保存目标对象
	private IUserDao userDao;
	
	public UserDaoProxy(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		System.out.println("开始事务...");
		//执行目标对象的方法
		userDao.save();
	    System.out.println("提交事务...");
	}

}
