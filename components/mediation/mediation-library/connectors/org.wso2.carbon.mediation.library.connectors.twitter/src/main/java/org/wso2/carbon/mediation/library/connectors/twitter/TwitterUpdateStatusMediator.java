/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.mediation.library.connectors.twitter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.mediators.AbstractMediator;
import org.wso2.carbon.mediation.library.connectors.core.AbstractConnector;
import org.wso2.carbon.mediation.library.connectors.core.ConnectException;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterUpdateStatusMediator extends AbstractConnector {

	public static final String STATUS = "status";
	private static Log log = LogFactory.getLog(TwitterUpdateStatusMediator.class);

	public void connect(MessageContext messageContext) throws ConnectException {
		try {
			String statusStr = TwitterMediatorUtils.lookupFunctionParam(messageContext,
					STATUS);
			if (statusStr == null || "".equals(statusStr.trim())) {
				statusStr = "Houston, we have a problem!! #tweet #bad-status #wso2esb-twitter-connector";
			}
			Twitter twitter = new TwitterClientLoader(messageContext).loadApiClient();
			Status status = twitter.updateStatus(statusStr);
			TwitterMediatorUtils.storeResponseStatus(messageContext, status);
			log.info("@" + status.getUser().getScreenName() + " - " + status.getText());
		} catch (TwitterException te) {
			log.error("Failed to show status: " + te.getMessage(), te);
			TwitterMediatorUtils.storeErrorResponseStatus(messageContext, te);
		}
	}

}
