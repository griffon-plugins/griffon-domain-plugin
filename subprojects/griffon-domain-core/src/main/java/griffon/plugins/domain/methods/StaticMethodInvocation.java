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
package griffon.plugins.domain.methods;

import griffon.plugins.domain.GriffonDomain;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Andres Almiray
 */
public interface StaticMethodInvocation extends MethodInvocation {
    /**
     * <p>Invokes the actual method. The class, method name and arguments are provided.
     * If no arguments are passed the argument array is empty.
     *
     * @param clazz      the class the static method is called on
     * @param methodName the static method name
     * @param arguments  the arguments supplied
     * @return the return value of the static method invocation
     */
    @Nullable
    <T extends GriffonDomain> Object invoke(@Nonnull Class<T> clazz, @Nonnull String methodName, Object... arguments);
}