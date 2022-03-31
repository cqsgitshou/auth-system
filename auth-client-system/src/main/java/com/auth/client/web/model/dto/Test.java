package com.auth.client.web.model.dto;

import org.springframework.core.env.StandardEnvironment;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/8
 */
public class Test {

	public void propertyTest() {
		// Java 系统属性
		String key = "java.home";
		StandardEnvironment environment = new StandardEnvironment();

		// 获取 ${environment} 的值
		String property = environment.getProperty(key);
		System.out.println(String.format("Environment#getProperty(%s) = %s", key, property));

		// 解析占位符 ${environment}
		String placeholders = environment.resolvePlaceholders("${OAUTH2_RESOURCE_PREFERTOKENINFO:aaa}");
		System.out.println(placeholders);
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.propertyTest();
	}
}
