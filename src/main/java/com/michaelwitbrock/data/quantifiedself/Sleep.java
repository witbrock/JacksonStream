package com.michaelwitbrock.data.quantifiedself;
/**
 * @license APACHE LICENSE, VERSION 2.0 http://www.apache.org/licenses/LICENSE-2.0
 * @author Michael Witbrock
 */

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "date",
    "hours",
    "minutes"
})
public class Sleep {

    @JsonProperty("date")
    private String date;
    @JsonProperty("hours")
    private Integer hours;
    @JsonProperty("minutes")
    private Integer minutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The hours
     */
    @JsonProperty("hours")
    public Integer getHours() {
        return hours;
    }

    /**
     * 
     * @param hours
     *     The hours
     */
    @JsonProperty("hours")
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * 
     * @return
     *     The minutes
     */
    @JsonProperty("minutes")
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * 
     * @param minutes
     *     The minutes
     */
    @JsonProperty("minutes")
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

 
    @Override
    public String toString() {
        return "Date:"+getDate()+" Hours:"+getHours()+" Minutes:"+getMinutes();
//        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(date).append(hours).append(minutes).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sleep) == false) {
            return false;
        }
        Sleep rhs = ((Sleep) other);
        return new EqualsBuilder().append(date, rhs.date).append(hours, rhs.hours).append(minutes, rhs.minutes).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}