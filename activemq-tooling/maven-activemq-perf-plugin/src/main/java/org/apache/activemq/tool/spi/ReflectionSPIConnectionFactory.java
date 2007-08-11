/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.tool.spi;

import org.apache.activemq.tool.properties.ReflectionUtil;

import javax.jms.ConnectionFactory;
import java.util.Properties;

public abstract class ReflectionSPIConnectionFactory extends ClassLoaderSPIConnectionFactory {

    public ConnectionFactory instantiateConnectionFactory(Properties settings) throws Exception {
        Class factoryClass = Thread.currentThread().getContextClassLoader().loadClass(getClassName());
        ConnectionFactory factory = (ConnectionFactory)factoryClass.newInstance();
        configureConnectionFactory(factory, settings);
        return factory;
    }

    public void configureConnectionFactory(ConnectionFactory jmsFactory, Properties settings) throws Exception {
        ReflectionUtil.configureClass(jmsFactory, settings);
    }

    public abstract String getClassName();
}
