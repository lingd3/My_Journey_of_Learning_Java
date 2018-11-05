package org.dan.redpacket.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
// ����Springɨ��İ�
@ComponentScan(value = "org.*", includeFilters = { @Filter(type = FilterType.ANNOTATION, value = { Service.class }) })
// ʹ����������������
@EnableTransactionManagement
// ʵ�ֽӿ�TransactionManagementConfigurer��������������ע����������
public class RootConfig implements TransactionManagementConfigurer {

	private DataSource dataSource = null;

	/*
	 * �������ݿ�
	 */
	@Bean(name = "dataSource")
	public DataSource initDataSource() {
		if (dataSource != null) {
			return dataSource;
		}
		try {
			Properties props = new Properties();
			props.load(RootConfig.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			props.setProperty("driverClassName", props.getProperty("jdbc.driver"));
			props.setProperty("url", props.getProperty("jdbc.url"));
			props.setProperty("username", props.getProperty("jdbc.username"));
			props.setProperty("password", props.getProperty("jdbc.password"));
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	/*
	 * ����SqlSessionFactoryBean
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean initSqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(initDataSource());
		// ����MyBatis�����ļ�
		Resource resource = new ClassPathResource("mybatis/mybatis-config.xml");
		sqlSessionFactory.setConfigLocation(resource);
		return sqlSessionFactory;
	}

	/*
	 * ͨ���Զ�ɨ�裬����MyBatis Mapper�ӿ�
	 */
	@Bean
	public MapperScannerConfigurer initMapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("org.*");
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		msc.setAnnotationClass(Repository.class);
		return msc;
	}

	/*
	 * ʵ�ֽӿڷ�����ע��ע�����񣬵�@Transactional ʹ�õ�ʱ��������ݿ�����
	 */
	@Bean(name = "annotationDrivenTransactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(initDataSource());
		return transactionManager;
	}

}
