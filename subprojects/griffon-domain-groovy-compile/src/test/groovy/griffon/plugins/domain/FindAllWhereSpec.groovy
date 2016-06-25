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
package griffon.plugins.domain

import griffon.core.test.GriffonUnitRule
import org.junit.Rule
import spock.lang.Unroll

@Unroll
class FindAllWhereSpec extends PersistentSpecSupport {
    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    void "Empty result when invoking findAllWhere() on an empty dataset"() {
        expect:
        !Employee.findAllWhere(* arguments)

        where:
        arguments << [
            [[lastname: 'Alison']],
            [[lastname: 'Alison'], [max: 1]],
        ]
    }

    void "Full result when invoking findAllWhere() on dataset"() {
        given:
        insertEmployeesIntoDataset()

        when:
        def employees = Employee.findAllWhere(* arguments)

        then:
        employees.size() == size
        employees[0].name == 'Alice'

        where:
        size | arguments
        2    | [[lastname: 'Alison']]
        1    | [[lastname: 'Alison'], [max: 1]]
    }
}
