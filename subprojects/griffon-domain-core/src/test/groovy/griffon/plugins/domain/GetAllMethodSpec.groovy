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
class GetAllMethodSpec extends PersistentMethodSpecSupport {
    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    void "Empty result when invoking getAll() on an empty dataset"() {
        expect:
        !griffonDomainHandler.getAll(Person)
        !griffonDomainHandler.getAll(Person, [2L, 4L, 7L])
        !griffonDomainHandler.getAll(Person, [2L, 4L, 7L] as Object[])
    }

    void "Full result when invoking getAll() on dataset"() {
        given:
        insertPeopleIntoDataset()

        when:
        def people = griffonDomainHandler.getAll(Person, [2L, 4L, 7L])

        then:
        people.name == ['Alice', 'Bob', 'Elmer']
        people.lastname == ['Elmerson', 'Elmerson', 'Elmerson']
    }
}
