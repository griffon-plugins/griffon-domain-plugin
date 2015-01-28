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
package griffon.plugins.domain.methods;

import java.util.List;

/**
 * @author Andres Almiray
 */
public interface CountByMethod extends StaticDynamicMethodInvocation {
    String OPERATOR_OR = "Or";
    String OPERATOR_AND = "And";
    String[] OPERATORS = new String[]{OPERATOR_AND, OPERATOR_OR};

    String METHOD_NAME = "countBy";

    MethodSignature[] METHOD_SIGNATURES = new MethodSignature[]{
        new MethodSignature(true, Integer.TYPE, METHOD_NAME, String.class, Object[].class),
        new MethodSignature(true, Integer.TYPE, METHOD_NAME, String.class, List.class)
    };
}