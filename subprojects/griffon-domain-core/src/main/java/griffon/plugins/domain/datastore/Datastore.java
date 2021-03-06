/*
 * Copyright 2014-2016 the original author or authors.
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
package griffon.plugins.domain.datastore;

import griffon.plugins.domain.GriffonDomain;
import griffon.plugins.domain.GriffonDomainClass;

import javax.annotation.Nonnull;

/**
 * @author Andres Almiray
 */
public interface Datastore {
    @Nonnull
    String getName();

    @Nonnull
    <T extends GriffonDomain> Dataset<T> dataset(@Nonnull String name);

    @Nonnull
    <T extends GriffonDomain> Dataset<T> dataset(@Nonnull GriffonDomainClass<T> domainClass);
}
