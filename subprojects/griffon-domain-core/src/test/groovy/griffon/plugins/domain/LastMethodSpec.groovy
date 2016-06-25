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
class LastMethodSpec extends PersistentMethodSpecSupport {
    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    void "Empty result when invoking last() on an empty dataset"() {
        expect:
        List args = [Person] + arguments
        !griffonDomainHandler.last(* args)

        where:
        arguments << [
            [],
            ['lastname'],
            [sort: 'lastname']
        ]
    }

    void "Full result when invoking last() on dataset"() {
        given:
        insertPeopleIntoDataset()

        when:
        List args = [Person] + arguments
        Person person = griffonDomainHandler.last(* args)

        then:
        person.name == name

        where:
        name    | id | arguments
        'Elmer' | 7  | []
        'Alice' | 2  | ['lastname']
        'Alice' | 2  | [sort: 'lastname']
    }
}
