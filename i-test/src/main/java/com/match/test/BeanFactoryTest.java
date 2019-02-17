package com.match.test;


import com.match.bean.ITestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

	public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		ITestBean bean = (ITestBean) bf.getBean("iTestBean");
		bean.setName("测试");
		System.out.println(bean);
	}
}
