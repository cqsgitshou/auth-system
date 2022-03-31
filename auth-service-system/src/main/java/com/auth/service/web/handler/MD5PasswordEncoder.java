package com.auth.service.web.handler;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 业务关联查询
 *
 * @author chenqs
 * @date 2022/3/16
 */
public class MD5PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {

		return DigestUtil.md5Hex(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		String rawPasswordEncoded = DigestUtil.md5Hex(rawPassword.toString());
		return rawPasswordEncoded.equals(encodedPassword);
		// return false;
	}


}
