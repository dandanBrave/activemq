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

package org.apache.activemq.ra;

import javax.jms.JMSException;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapter;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Knows how to connect to one ActiveMQ server. It can then activate endpoints
 * and deliver messages to those end points using the connection configure in
 * the resource adapter. <p/>Must override equals and hashCode (JCA spec 16.4)
 *
 * @org.apache.xbean.XBean element="resourceAdapter" rootElement="true"
 * description="The JCA Resource Adaptor for ActiveMQ"
 * @version $Revision$
 */
public interface MessageResourceAdapter
        extends ResourceAdapter
{

    /**
     */
	public ActiveMQConnection makeConnection()
		throws JMSException;

    /**
     */
	public ActiveMQConnection makeConnection(ActiveMQConnectionRequestInfo info)
		throws JMSException;

    /**
     */
	public ActiveMQConnection makeConnection(ActiveMQConnectionRequestInfo info, ActiveMQConnectionFactory connectionFactory)
		throws JMSException;

    /**
	 * @param activationSpec
     */
	public ActiveMQConnection makeConnection(MessageActivationSpec activationSpec)
		throws JMSException;

    /**
	 * @return bootstrap context
     */
	public BootstrapContext getBootstrapContext();

    /**
     */
	public String getBrokerXmlConfig();

    /**
     * @return Returns the info.
     */
	public ActiveMQConnectionRequestInfo getInfo();

    /**
     */
	public ActiveMQConnectionFactory getConnectionFactory();

}
