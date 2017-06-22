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
package org.codehaus.griffon.runtime.domain.constraints;

import griffon.plugins.domain.GriffonDomainClass;
import griffon.plugins.domain.GriffonDomainClassProperty;
import griffon.plugins.domain.GriffonDomainProperty;
import griffon.plugins.domain.constraints.GriffonDomainConstraintsEvaluator;
import griffon.plugins.validation.constraints.ConstrainedProperty;
import org.codehaus.griffon.runtime.validation.constraints.DefaultConstraintsEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author Andres Almiray
 */
public class DefaultGriffonDomainConstraintsEvaluator extends DefaultConstraintsEvaluator implements GriffonDomainConstraintsEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultGriffonDomainConstraintsEvaluator.class);

    @Nonnull
    @Override
    public Map<String, ConstrainedProperty> evaluate(@Nonnull GriffonDomainClass<?> cls) {
        return evaluate(cls.getClazz(), cls.getPersistentProperties());
    }

    @Nonnull
    @Override
    public Map<String, ConstrainedProperty> evaluate(@Nonnull Object object, @Nonnull GriffonDomainClassProperty[] properties) {
        return evaluateConstraints(object.getClass(), properties);
    }

    @Nonnull
    @Override
    public Map<String, ConstrainedProperty> evaluate(@Nonnull Class<?> cls, @Nonnull GriffonDomainClassProperty[] properties) {
        return evaluateConstraints(cls, properties);
    }

    protected boolean isConstrainableProperty(String propertyName) {
        return super.isConstrainableProperty(propertyName) &&
            !propertyName.equals(GriffonDomainProperty.DATE_CREATED) &&
            !propertyName.equals(GriffonDomainProperty.LAST_UPDATED) &&
            !GriffonDomainProperty.VERSION.equals(propertyName) &&
            !GriffonDomainProperty.IDENTITY.equals(propertyName);
    }
}
