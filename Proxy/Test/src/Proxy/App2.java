package Proxy;

/**
* 测试类
*/
public class App2 {
   public static void main(String[] args) {
       // 目标对象
       IUserDao userDao = new UserDao();
       // 【原始的类型 class Proxy.UserDao】
       System.out.println(userDao.getClass());

       // 给目标对象，创建代理对象
       IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
       // class com.sun.proxy.$Proxy0  内存中动态生成的代理对象
       System.out.println(proxy.getClass());

       // 执行方法【代理对象】
       proxy.save();
   }
}