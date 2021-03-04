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

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 *
 */
public class JsonRSocketMessageCatalogTests {

	private JsonRSocketMessageCatalog catalog = new JsonRSocketMessageCatalog();

	@Test
	public void channel() throws Exception {
		catalog.afterPropertiesSet();
		MessageMapping mapping = catalog.getMapping("channel");
		assertThat(mapping.handle(Flux.just(new HashMap<>())).toIterable()).hasSize(1);
	}

	@Test
	public void stream() throws Exception {
		catalog.afterPropertiesSet();
		MessageMapping mapping = catalog.getMapping("long");
		assertThat(mapping.handle(Flux.just(new HashMap<>())).toIterable()).hasSize(15);
	}

}
