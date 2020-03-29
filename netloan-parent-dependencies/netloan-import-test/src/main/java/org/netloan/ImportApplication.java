package org.netloan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author lixh
 * <p> 如何自定义 EnableXXXXX，自动注入</p>
 *   定义：EnableUserBean 注解方法，通过@Import注解导入ImportSelect实现类完成
 *  
 */

@EnableUserBean
public class ImportApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportApplication.class);

		User user = context.getBean(User.class);

		System.out.println(user);
	}
}
