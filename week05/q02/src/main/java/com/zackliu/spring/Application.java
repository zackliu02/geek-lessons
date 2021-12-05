package com.zackliu.spring;

import com.zackliu.spring.bean.CodeGeneratorConfig;
import com.zackliu.spring.bean.CodeGeneratorExample;
import com.zackliu.spring.component.ComponentExample;
import com.zackliu.spring.conditional.ConditionalConfig;
import com.zackliu.spring.conditional.ConditionalExample;
import com.zackliu.spring.xml.XmlExample;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	//参考 https://blog.csdn.net/m0_53157173/article/details/119491045
	public static void main(String[] args) {
		//1.xml配置方式
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlExample xmlExample = (XmlExample) context.getBean("xmlExample");
		xmlExample.showInfo();
//		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

		//2.包扫描+@Component注解方式
		ComponentExample componentExample = (ComponentExample) context.getBean("componentExample");
		componentExample.showInfo();
//		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

		//3.@Bean+@Config方式，由方法返回值生成一个bean
		ApplicationContext context1 = new AnnotationConfigApplicationContext(CodeGeneratorConfig.class);
		CodeGeneratorExample codeGeneratorExample = (CodeGeneratorExample) context1.getBean("getCodeExample");
		codeGeneratorExample.showInfo();
//		System.out.println(Arrays.toString(context1.getBeanDefinitionNames()));

		//4.@Conditional方式
		ApplicationContext context2 = new AnnotationConfigApplicationContext(ConditionalConfig.class);
		ConditionalExample conditionalExample = (ConditionalExample) context2.getBean("getConditionalExample");
		conditionalExample.showInfo();
//		System.out.println(Arrays.toString(context2.getBeanDefinitionNames()));
	}

}
