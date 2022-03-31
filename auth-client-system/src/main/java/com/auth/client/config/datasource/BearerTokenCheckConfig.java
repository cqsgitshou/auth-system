/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.auth.client.config.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 改造 {@link BearerTokenExtractor} 对公开权限的请求不进行校验
 *
 * @author caiqy
 * @date 2020.05.15
 */
public class BearerTokenCheckConfig extends BearerTokenExtractor {
	@Getter
	@Setter
	private List<String> urls = new ArrayList<>();

	private PathMatcher pathMatcher = new AntPathMatcher();
	public BearerTokenCheckConfig() {
		urls.add("/auth/skip/*");
	}

	@Override
	public Authentication extract(HttpServletRequest request) {
		boolean match = urls.stream()
				.anyMatch(url -> pathMatcher.match(url, request.getRequestURI()));

		return match ? null : super.extract(request);
	}

}
