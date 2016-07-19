/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.fetcher.api.v2010.account.sms;

import com.twilio.sdk.http.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.account.sms.ShortCode;

public class ShortCodeFetcher extends Fetcher<ShortCode> {
    private String accountSid;
    private final String sid;

    /**
     * Construct a new ShortCodeFetcher.
     * 
     * @param sid Fetch by unique short-code Sid
     */
    public ShortCodeFetcher(final String sid) {
        this.sid = sid;
    }

    /**
     * Construct a new ShortCodeFetcher.
     * 
     * @param accountSid The account_sid
     * @param sid Fetch by unique short-code Sid
     */
    public ShortCodeFetcher(final String accountSid, 
                            final String sid) {
        this.accountSid = accountSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched ShortCode
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ShortCode execute(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.accountSid + "/SMS/ShortCodes/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("ShortCode fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return ShortCode.fromJson(response.getStream(), client.getObjectMapper());
    }
}