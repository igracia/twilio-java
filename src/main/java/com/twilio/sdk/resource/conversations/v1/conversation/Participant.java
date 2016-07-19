/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.conversations.v1.conversation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.creator.conversations.v1.conversation.ParticipantCreator;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.conversations.v1.conversation.ParticipantFetcher;
import com.twilio.sdk.reader.conversations.v1.conversation.ParticipantReader;
import com.twilio.sdk.resource.SidResource;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant extends SidResource {
    private static final long serialVersionUID = 234988862687153L;

    public enum Status {
        CREATED("created"),
        CONNECTING("connecting"),
        CONNECTED("connected"),
        DISCONNECTED("disconnected"),
        FAILED("failed");
    
        private final String value;
        
        private Status(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Status.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a ParticipantReader to execute read.
     * 
     * @param conversationSid The conversation_sid
     * @return ParticipantReader capable of executing the read
     */
    public static ParticipantReader read(final String conversationSid) {
        return new ParticipantReader(conversationSid);
    }

    /**
     * Create a ParticipantCreator to execute create.
     * 
     * @param conversationSid The conversation_sid
     * @param to The to
     * @param from The from
     * @return ParticipantCreator capable of executing the create
     */
    public static ParticipantCreator create(final String conversationSid, 
                                            final com.twilio.sdk.type.PhoneNumber to, 
                                            final com.twilio.sdk.type.PhoneNumber from) {
        return new ParticipantCreator(conversationSid, to, from);
    }

    /**
     * Create a ParticipantFetcher to execute fetch.
     * 
     * @param conversationSid The conversation_sid
     * @param sid The sid
     * @return ParticipantFetcher capable of executing the fetch
     */
    public static ParticipantFetcher fetch(final String conversationSid, 
                                           final String sid) {
        return new ParticipantFetcher(conversationSid, sid);
    }

    /**
     * Converts a JSON String into a Participant object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String address;
    private final Participant.Status status;
    private final String conversationSid;
    private final DateTime dateCreated;
    private final DateTime startTime;
    private final DateTime endTime;
    private final Integer duration;
    private final String accountSid;
    private final URI url;

    @JsonCreator
    private Participant(@JsonProperty("sid")
                        final String sid, 
                        @JsonProperty("address")
                        final String address, 
                        @JsonProperty("status")
                        final Participant.Status status, 
                        @JsonProperty("conversation_sid")
                        final String conversationSid, 
                        @JsonProperty("date_created")
                        final String dateCreated, 
                        @JsonProperty("start_time")
                        final String startTime, 
                        @JsonProperty("end_time")
                        final String endTime, 
                        @JsonProperty("duration")
                        final Integer duration, 
                        @JsonProperty("account_sid")
                        final String accountSid, 
                        @JsonProperty("url")
                        final URI url) {
        this.sid = sid;
        this.address = address;
        this.status = status;
        this.conversationSid = conversationSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.startTime = DateConverter.iso8601DateTimeFromString(startTime);
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.duration = duration;
        this.accountSid = accountSid;
        this.url = url;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The address.
     * 
     * @return The address
     */
    public final String getAddress() {
        return this.address;
    }

    /**
     * Returns The The status.
     * 
     * @return The status
     */
    public final Participant.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The conversation_sid.
     * 
     * @return The conversation_sid
     */
    public final String getConversationSid() {
        return this.conversationSid;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The start_time.
     * 
     * @return The start_time
     */
    public final DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns The The end_time.
     * 
     * @return The end_time
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The duration.
     * 
     * @return The duration
     */
    public final Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Participant other = (Participant) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(address, other.address) && 
               Objects.equals(status, other.status) && 
               Objects.equals(conversationSid, other.conversationSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(startTime, other.startTime) && 
               Objects.equals(endTime, other.endTime) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            address,
                            status,
                            conversationSid,
                            dateCreated,
                            startTime,
                            endTime,
                            duration,
                            accountSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("address", address)
                          .add("status", status)
                          .add("conversationSid", conversationSid)
                          .add("dateCreated", dateCreated)
                          .add("startTime", startTime)
                          .add("endTime", endTime)
                          .add("duration", duration)
                          .add("accountSid", accountSid)
                          .add("url", url)
                          .toString();
    }
}