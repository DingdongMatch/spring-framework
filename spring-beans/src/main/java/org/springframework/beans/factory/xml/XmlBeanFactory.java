/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.Resource;

/**
 * Convenience extension of {@link DefaultListableBeanFactory} that reads bean definitions
 * from an XML document. Delegates to {@link XmlBeanDefinitionReader} underneath; effectively
 * equivalent to using an XmlBeanDefinitionReader with a DefaultListableBeanFactory.
 *
 * {@link DefaultListableBeanFactory}的便捷拓展，它委托下面的{@link XmlBeanDefinitionReader}，从XML文件中读取bean的定义。
 * 实际上相当于使用带有DefaultListableBeanFactory的XmlBeanDefinitionReader。
 *
 * <p>The structure, element and attribute names of the required XML document
 * are hard-coded in this class. (Of course a transform could be run if necessary
 * to produce this format). "beans" doesn't need to be the root element of the XML
 * document: This class will parse all bean definition elements in the XML file.
 *
 * <p>在此类中对所需要的XML文件的解构、元素及属性的名称进行了硬编码。（当然如果必要的话可以运行一个transform来产生这样的格式）。
 * 对于XML文件中的"beans"来说不需要根元素：这个类将会解析XML文件中定义的所有bean元素。
 *
 * <p>This class registers each bean definition with the {@link DefaultListableBeanFactory}
 * superclass, and relies on the latter's implementation of the {@link BeanFactory} interface.
 * It supports singletons, prototypes, and references to either of these kinds of bean.
 * See {@code "spring-beans-3.x.xsd"} (or historically, {@code "spring-beans-2.0.dtd"}) for
 * details on options and configuration style.
 *
 * <p>此类使用DefaultListableBeanFactory超类注册每个bean定义，并依赖于后者对BeanFactory接口的实现。
 * 它支持单例，原型和这些bean的所有引用。详细的选项及配置方式，请参考{@code“spring-beans-3.x.xsd”}
 * （或旧的，{@code“spring-beans-2.0.dtd”}）。
 *
 * <p><b>For advanced needs, consider using a {@link DefaultListableBeanFactory} with
 * an {@link XmlBeanDefinitionReader}.</b> The latter allows for reading from multiple XML
 * resources and is highly configurable in its actual XML parsing behavior.
 *
 * <p><b>对于高级需求，请考虑将{@link DefaultListableBeanFactory}与{@link XmlBeanDefinitionReader}一起使用。
 * <b>后者允许读取多个XML资源，并且在其实际的XML解析行为中具有更高可配置性。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Chris Beams
 * @author Match Fu(添加中文注释）
 * @since 15 April 2001
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 * @see XmlBeanDefinitionReader
 * @deprecated as of Spring 3.1 in favor of {@link DefaultListableBeanFactory} and
 * {@link XmlBeanDefinitionReader}
 */
@Deprecated
@SuppressWarnings({"serial", "all"})
public class XmlBeanFactory extends DefaultListableBeanFactory {
	/**
	 * 资源文件的读取、解析、注册
	 */
	private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);


	/**
	 * Create a new XmlBeanFactory with the given resource,
	 * which must be parsable using DOM.
	 * @param resource the XML resource to load bean definitions from
	 * @throws BeansException in case of loading or parsing errors
	 */
	/**
	 * 使用给定的输入流创建一个新的XmlBeanFactory，
	 * 必须可以使用DOM进行解析（输入流）。
	 * @param resource XML资源文件，从这里加载定义的bean
	 * @throws BeansException 加载和解析异常处理
	 */
	public XmlBeanFactory(Resource resource) throws BeansException {
		this(resource, null);
	}

	/**
	 * Create a new XmlBeanFactory with the given input stream,
	 * which must be parsable using DOM.
	 * @param resource the XML resource to load bean definitions from
	 * @param parentBeanFactory parent bean factory
	 * @throws BeansException in case of loading or parsing errors
	 */
	/**
	 * 使用给定的输入流创建一个新的XmlBeanFactory，
	 * 必须可以使用DOM进行解析（输入流）。
	 * @param resource XML资源文件，从这里加载定义的bean
	 * @param parentBeanFactory 父bean工程
	 * @throws BeansException 加载和解析异常处理
	 */
	public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
		super(parentBeanFactory);
		this.reader.loadBeanDefinitions(resource);
	}

}
