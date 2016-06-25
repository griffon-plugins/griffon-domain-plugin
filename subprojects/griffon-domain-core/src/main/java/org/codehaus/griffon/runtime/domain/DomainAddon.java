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

import griffon.core.GriffonApplication;
import griffon.core.artifact.ArtifactManager;
import org.codehaus.griffon.runtime.core.addon.AbstractGriffonAddon;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Andres Almiray
 */
@Named("domain")
public class DomainAddon extends AbstractGriffonAddon {
    @Inject
    private ArtifactManager artifactManager;

    public void init(@Nonnull GriffonApplication application) {
        GriffonDomainHandlerRegistry.init(artifactManager);
    }

    @Override
    public void onShutdown(@Nonnull GriffonApplication application) {
        GriffonDomainHandlerRegistry.cleanup();
    }
}
