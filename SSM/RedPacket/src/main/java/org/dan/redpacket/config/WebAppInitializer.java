package org.dan.redpacket.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Spring IOC��������
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// ����Spring IoC��Դ
		return new Class<?>[] { RootConfig.class };
	}

	// DispatcherServlet��������
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// ����Java������
		return new Class<?>[] { WebConfig.class };
	}

	// DispatchServlet������������
	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.do" };
	}

	/*
	 * Servlet�ϴ��ļ�����.
	 */
	@Override
	protected void customizeRegistration(Dynamic dynamic) {
		// �����ϴ��ļ�·��
		String filepath = "D:/";
		// 5MB
		Long singleMax = (long) (5 * Math.pow(2, 20));
		// 10MB
		Long totalMax = (long) (10 * Math.pow(2, 20));
		// �����ϴ��ļ�����
		dynamic.setMultipartConfig(new MultipartConfigElement(filepath, singleMax, totalMax, 0));
	}

}
