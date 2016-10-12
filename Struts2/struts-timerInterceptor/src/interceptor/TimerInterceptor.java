package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/*
 * 创建拦截器步骤：
 * 1.创建一个继承自AbstractInterceptor的类
 * 2.实现intercept方法
 * 3.配置拦截器：
 * 	 ①注册拦截器
 * 	 ②引用拦截器
 */
public class TimerInterceptor extends AbstractInterceptor {

	//自动调用此方法，进行拦截操作
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1.执行Action之前
		long start = System.currentTimeMillis();
		//2.执行下一个拦截器，如果已经是最后一个拦截器，则执行目标Action
		String result = invocation.invoke();
		//3.执行Action后 
		long end = System.currentTimeMillis();
		System.out.println("执行Action花费的时间：" + (end-start) + "ms");
		return result;
	}

}
