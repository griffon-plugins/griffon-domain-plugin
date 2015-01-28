/*
 * Copyright 2014-2015 the original author or authors.
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
package griffon.plugins.domain.exceptions;

import griffon.exceptions.GriffonException;

import javax.annotation.Nonnull;

/**
 * @author Andres Almiray
 */
public class InvalidPropertyException extends GriffonException {
    private static final long serialVersionUID = -6717590504008299528L;

    public InvalidPropertyException(@Nonnull Class<?> klass, @Nonnull String propertyName) {
        super(formatArgs(klass, propertyName));
    }

    public InvalidPropertyException(@Nonnull Class<?> klass, @Nonnull String propertyName, @Nonnull Throwable cause) {
        super(formatArgs(klass, propertyName), checkNonNull(cause, "cause"));
    }

    @Nonnull
    private static String formatArgs(@Nonnull Class<?> klass, @Nonnull String propertyName) {
        checkNonNull(klass, "klass");
        checkNonBlank(propertyName, "propertyName");
        return "Cannot get property " + propertyName + " from " + klass;
    }
}
