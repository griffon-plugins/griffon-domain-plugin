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
package org.codehaus.griffon.compile.domain

import org.codehaus.griffon.compile.core.BaseConstants
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ConstantsSpec extends Specification implements BaseConstants {
    void "Verify methods of #classname"() {
        given:
        def actualMethods = classname.METHODS
        actualMethods.each { println it }

        expect:
        actualMethods.size() == methods.size()
        actualMethods.each { assert methods.contains(it.toString()) }

        where:
        classname       | methods
        DomainConstants | DOMAIN_METHODS
    }


    private static final List<String> DOMAIN_METHODS = [
        'public static int countBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1)',
        'public static int countBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1)',
        'public static int count()',
        '@javax.annotation.Nonnull public static T create()',
        '@javax.annotation.Nonnull public static T create(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public T delete()',
        '@javax.annotation.Nonnull public T delete(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        'public static boolean exists(@javax.annotation.Nonnull java.lang.Object arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg2)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg2)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull java.lang.Object arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull java.lang.Object arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAll(@javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion arg0, @javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> findAllWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nullable public static T findBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1)',
        '@javax.annotation.Nullable public static T findBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1)',
        '@javax.annotation.Nullable public static T find(@javax.annotation.Nonnull java.lang.Object arg0)',
        '@javax.annotation.Nullable public static T find(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nullable public static T find(@javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion arg0)',
        '@javax.annotation.Nullable public static T findOrCreateBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1)',
        '@javax.annotation.Nullable public static T findOrCreateBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1)',
        '@javax.annotation.Nullable public static T findOrCreateWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nullable public static T findOrSaveBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1)',
        '@javax.annotation.Nullable public static T findOrSaveBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1)',
        '@javax.annotation.Nullable public static T findOrSaveBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.lang.Object[] arg1, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg2)',
        '@javax.annotation.Nullable public static T findOrSaveBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.List arg1, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg2)',
        '@javax.annotation.Nullable public static T findOrSaveWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nullable public static T findOrSaveWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nullable public static T findWhere(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nullable public static T first()',
        '@javax.annotation.Nullable public static T first(@javax.annotation.Nonnull java.lang.String arg0)',
        '@javax.annotation.Nullable public static T first(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> getAll()',
        '@javax.annotation.Nonnull public static java.util.Collection<T> getAll(@javax.annotation.Nonnull java.lang.Object[] arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> getAll(@javax.annotation.Nonnull java.util.List arg0)',
        '@javax.annotation.Nullable public static T get(@javax.annotation.Nonnull java.lang.Object arg0)',
        '@javax.annotation.Nullable public static T last()',
        '@javax.annotation.Nullable public static T last(@javax.annotation.Nonnull java.lang.String arg0)',
        '@javax.annotation.Nullable public static T last(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> list()',
        '@javax.annotation.Nonnull public static java.util.Collection<T> list(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> listOrderBy(@javax.annotation.Nonnull java.lang.String arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> listOrderBy(@javax.annotation.Nonnull java.lang.String arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)',
        '@javax.annotation.Nonnull public T save()',
        '@javax.annotation.Nonnull public T save(@javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> withCriteria(@javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion arg0)',
        '@javax.annotation.Nonnull public static java.util.Collection<T> withCriteria(@javax.annotation.Nonnull griffon.plugins.domain.orm.Criterion arg0, @javax.annotation.Nonnull java.util.Map<java.lang.String, java.lang.Object> arg1)'
    ]
}
