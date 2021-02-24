/*
 * Copyright 2020-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.mock.rsocket;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dave Syer
 *
 */
@Configuration(proxyBeanMethods = false)
public class RSocketServerConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public RSocketMessageCatalog rSocketMessageCatalog() {
		return new JsonRSocketMessageCatalog();
	}

	@Bean
	public RSocketRouter customFunctionRouter() {
		return new RSocketRouter();
	}

	@Bean("fire-and-forget")
	public FireAndForgetHandler fireAndForgetHandler(RSocketMessageCatalog catalog) {
		return new FireAndForgetHandler(catalog);
	}

	@Bean("request-response")
	public RequestResponseHandler requestResponseHandler(RSocketMessageCatalog catalog) {
		return new RequestResponseHandler(catalog);
	}

	@Bean("request-stream")
	public RequestStreamHandler requestStreamHandler(RSocketMessageCatalog catalog) {
		return new RequestStreamHandler(catalog);
	}

	@Bean("request-channel")
	public RequestChannelHandler requestChannelHandler(RSocketMessageCatalog catalog) {
		return new RequestChannelHandler(catalog);
	}
}