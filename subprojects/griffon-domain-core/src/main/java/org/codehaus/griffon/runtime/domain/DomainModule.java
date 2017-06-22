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
package org.codehaus.griffon.runtime.domain;

import griffon.core.addon.GriffonAddon;
import griffon.core.artifact.ArtifactHandler;
import griffon.core.injection.Module;
import griffon.inject.DependsOn;
import griffon.plugins.domain.GriffonDomainHandler;
import griffon.plugins.domain.datastore.Datastore;
import griffon.plugins.domain.datastore.DatastoreFactory;
import griffon.plugins.domain.datastore.DatastoreHandler;
import griffon.plugins.domain.datastore.DatastoreStorage;
import griffon.plugins.domain.orm.BeanCriterionEvaluator;
import griffon.plugins.domain.orm.CriterionEvaluator;
import org.codehaus.griffon.runtime.core.injection.AbstractModule;
import org.codehaus.griffon.runtime.domain.datastore.DefaultDatastore;
import org.codehaus.griffon.runtime.domain.datastore.DefaultDatastoreFactory;
import org.codehaus.griffon.runtime.domain.datastore.DefaultDatastoreHandler;
import org.codehaus.griffon.runtime.domain.datastore.DefaultDatastoreStorage;
import org.codehaus.griffon.runtime.domain.datastore.MemoryGriffonDomainHandler;
import org.kordamp.jipsy.ServiceProviderFor;

import javax.inject.Named;

import static griffon.util.AnnotationUtils.named;

/**
 * @author Andres Almiray
 */
@Named("domain")
@DependsOn("validation")
@ServiceProviderFor(Module.class)
public class DomainModule extends AbstractModule {
    @Override
    protected void doConfigure() {
        bind(DatastoreHandler.class)
            .to(DefaultDatastoreHandler.class)
            .asSingleton();

        bind(DatastoreFactory.class)
            .to(DefaultDatastoreFactory.class)
            .asSingleton();

        bind(DatastoreStorage.class)
            .to(DefaultDatastoreStorage.class)
            .asSingleton();

        bind(Datastore.class)
            .withClassifier(named("default"))
            .to(DefaultDatastore.class)
            .asSingleton();

        bind(GriffonDomainHandler.class)
            .withClassifier(named("memory"))
            .to(MemoryGriffonDomainHandler.class)
            .asSingleton();

        bind(ArtifactHandler.class)
            .to(DomainArtifactHandler.class)
            .asSingleton();

        bind(CriterionEvaluator.class)
            .to(BeanCriterionEvaluator.class)
            .asSingleton();

        bind(GriffonAddon.class)
            .to(DomainAddon.class)
            .asSingleton();
    }
}
