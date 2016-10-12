package com.imooc.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="AsynFilter", value={"/servlet/AsynServlet"}, asyncSupported=true, dispatcherTypes={DispatcherType.REQUEST, DispatcherType.ASYNC})
public class AsynFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("start......AsynFilter");
		arg2.doFilter(arg0, arg1);
		System.out.println("end......AsynFilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
