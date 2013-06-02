/*
 * Copyright 2001-2008 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.uddi.v3_service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.uddi.api_v3.DispositionReport;
import org.uddi.subr_v3.NotifySubscriptionListener;

/**
 * This portType defines all of the UDDI subscriptionListener operations.
 *
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.5-b03- Generated
 * source version: 2.1
 * 
 * <h1>Notes from the jUDDI development team</h1>
 * To implement a callback for UDDI subscriptions:
 * <ol><li>Implement your own instance of this class.</li>
 * <li>Decide whether or not you want to host your implementation within a web servlet container. If the answer is yes, follow standard procedures for doing so.</li>
 * <li>If you're hosting it yourself, try out the following code. You'll need either JDK 1.6+ or Apache CXF with the Jetty libraries within your classpath
 * <pre>
     String url = "http://localhost:7777/uddi_subscription_back";
     Endpoint ep = Endpoint.publish(url, new ClientSubscriptionCallback(this));
</pre><br>
* Where "ClientSubscriptionCallback" is your implementation class for this interface
* </li>
* </ol>
 * 
 * <h1>Notes from the UDDI Spec</h1>
 * This API, when implemented by a subscriber and specified in a subscription,
 * enables the node to deliver notifications to subscription listeners by
 * invoking a Web service. New, modified, and deleted data that matches the
 * subscription is passed to notify_subscriptionListener. If the brief attribute
 * of the subscription is "true", then only the relevant keys will be sent; full
 * details of the changed data can be accomplished via the standard get_xx API’s
 * if required. If a particular item that matches the subscription criteria is
 * deleted during the notificationInterval, or is changed in such a way that it
 * no longer matches the criterion defined for the subscription, then these
 * entities are included in a keyBag containing a deleted element with a value
 * of "true".
 *
 * To allow subscribers to determine whether a notification has been lost, the
 * coverage period of the notification is included. A date/time indicating the
 * date/time values corresponding to the start and end points of this is
 * provided. The start date/time used in this call SHOULD align with the end
 * date/time of the previous call and so fourth.  *
 * If the maxEntities option was specified in the save_subscription call, the
 * response supplied via this call is limited to that number of entities. If the
 * node cannot send all of the results in a single notify_subscriptionListener
 * call, then the node repeatedly invokes the notify_subscriptionListener
 * service until all information has been transmitted. In no case will the data
 * sent to notify_subscriptionListener exceed the maximum message size per the
 * policy of the node.
 *
 */
@WebService(name = "UDDI_SubscriptionListener_PortType", targetNamespace = "urn:uddi-org:v3_service")
@XmlSeeAlso({
    org.uddi.custody_v3.ObjectFactory.class,
    org.uddi.repl_v3.ObjectFactory.class,
    org.uddi.subr_v3.ObjectFactory.class,
    org.uddi.api_v3.ObjectFactory.class,
    org.uddi.vscache_v3.ObjectFactory.class,
    org.uddi.vs_v3.ObjectFactory.class,
    org.uddi.sub_v3.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    org.uddi.policy_v3.ObjectFactory.class,
    org.uddi.policy_v3_instanceparms.ObjectFactory.class
})
public interface UDDISubscriptionListenerPortType extends Remote {

    /**
     * This API, when implemented by a subscriber and specified in a
     * subscription, enables the node to deliver notifications to subscription
     * listeners by invoking a Web service. New, modified, and deleted data that
     * matches the subscription is passed to notify_subscriptionListener. If the
     * brief attribute of the subscription is "true", then only the relevant
     * keys will be sent; full details of the changed data can be accomplished
     * via the standard get_xx API’s if required. If a particular item that
     * matches the subscription criteria is deleted during the
     * notificationInterval, or is changed in such a way that it no longer
     * matches the criterion defined for the subscription, then these entities
     * are included in a keyBag containing a deleted element with a value of
     * "true".
     *
     * To allow subscribers to determine whether a notification has been lost,
     * the coverage period of the notification is included. A date/time
     * indicating the date/time values corresponding to the start and end points
     * of this is provided. The start date/time used in this call SHOULD align
     * with the end date/time of the previous call and so fourth.      *
     * If the maxEntities option was specified in the save_subscription call,
     * the response supplied via this call is limited to that number of
     * entities. If the node cannot send all of the results in a single
     * notify_subscriptionListener call, then the node repeatedly invokes the
     * notify_subscriptionListener service until all information has been
     * transmitted. In no case will the data sent to notify_subscriptionListener
     * exceed the maximum message size per the policy of the node.
     *
     * @param body <p class="MsoBodyText"
     * style="margin-left:1.0in;text-indent:-.25in"><span
     * style="font-family:Symbol">·<span style="font:7.0pt &quot;Times New
     * Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * </span></span><b><i>authInfo</i></b>:&nbsp; This optional argument is an
     * element that contains an authentication token.&nbsp; Subscription
     * listener services that wish to restrict who can transmit subscription
     * data MAY require authInfo for this call, though this is a matter of
     * client policy.</p>
     *
     * <p class="MsoBodyText" style="margin-left:1.0in;text-indent:-.25in"><span
     * style="font-family:Symbol">·<span style="font:7.0pt &quot;Times New
     * Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * </span></span><b><i>subscriptionResultsList</i></b>:&nbsp; This list
     * contains the results for this notification, which consist of the result
     * structures which are normally returned for standard find_xx or get_xx
     * APIs, based upon the criteria saved in the subscriptionFilter for the
     * subscription which is generating this notification. Note that the
     * chunkToken is not returned with this structure for this API.&nbsp; The
     * subscriptionResultsList also contains a coveragePeriod structure which
     * defines the time period over which the node data is compared with the
     * subscription criterion in order to produce the result set. It provides
     * the start and end date/time information according to the format described
     * in Section <a href="#_Ref3402225 ">5.5.4</a> <i>Subscription Coverage
     * Period</i>.&nbsp; The "current" state of registry entries pertaining to
     * the subscription referenced by the subscriptionKey provided are returned
     * if they were last changed during the specified time period. See Section
     * <a href="#_Ref42320503 ">5.5.11.3</a> <i>Returns</i> for more information
     * on the subscriptionResultsList’s content.</p>
     * @return returns org.uddi.api_v3.DispositionReport Upon successful
     * completion, notify_subscriptionListener returns an empty message. Note
     * that this is being returned by the client supported API.
     * @throws DispositionReportFaultMessage <p class="MsoBodyText">If an error
     * occurs in processing this API call, a dispositionReport structure is
     * returned to the caller in a SOAP Fault.&nbsp; In addition to the errors
     * common to all APIs, the following error information is relevant here:</p>
     *
     * <p class="MsoBodyText" style="margin-left:1.0in;text-indent:-.25in"><span
     * style="font-family:Symbol">·<span style="font:7.0pt &quot;Times New
     * Roman&quot;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * </span></span><b>E_fatalError:&nbsp; </b>signifies the client’s failure
     * to receive notification data.&nbsp;&nbsp; The node is not obligated to
     * retry.</p>
     */
    @WebMethod(operationName = "notify_subscriptionListener", action = "notify_subscriptionListener")
    @WebResult(name = "dispositionReport", targetNamespace = "urn:uddi-org:api_v3", partName = "body")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public DispositionReport notifySubscriptionListener(
            @WebParam(name = "notify_subscriptionListener", targetNamespace = "urn:uddi-org:subr_v3", partName = "body") NotifySubscriptionListener body)
            throws DispositionReportFaultMessage, RemoteException;
}
