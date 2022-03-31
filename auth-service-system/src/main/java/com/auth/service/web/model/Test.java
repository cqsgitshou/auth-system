package com.auth.service.web.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/8
 */
public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = 	new BCryptPasswordEncoder();

		System.out.println(bCryptPasswordEncoder.encode("123456"));

	}
}
