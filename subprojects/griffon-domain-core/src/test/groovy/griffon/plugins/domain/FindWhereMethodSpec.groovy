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
class FindWhereMethodSpec extends PersistentMethodSpecSupport {
    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    void "New entity when invoking findWhere() on an empty dataset"() {
        when:
        def bob = griffonDomainHandler.findWhere(Person, [name: 'Bob', lastname: 'Elmerson'])

        then:
        bob == null
    }

    void "Found result when invoking findWhere() on dataset"() {
        given:
        insertPeopleIntoDataset()

        when:
        def bob1 = griffonDomainHandler.findWhere(Person, [name: 'Bob', lastname: 'Elmerson'])
        def bob2 = griffonDomainHandler.findWhere(Person, [name: 'Bob', lastname: 'Bobson'])

        then:
        bob1.id == 4
        bob2 == null
    }
}
