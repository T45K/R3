// Generated by delombok at Fri Sep 13 14:34:01 JST 2019
package com.rakuten.internship.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long rescueId;
    private String name;
    private String message;
    private boolean isRescuer;
    private Date timeStamp;

    @PrePersist
    private void onPrePersist() {
        if (timeStamp == null) {
            timeStamp = new Date();
        }
    }

    @java.lang.SuppressWarnings("all")
    public ChatMessage() {
    }

    @java.lang.SuppressWarnings("all")
    public long getId() {
        return this.id;
    }

    @java.lang.SuppressWarnings("all")
    public long getRescueId() {
        return this.rescueId;
    }

    @java.lang.SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @java.lang.SuppressWarnings("all")
    public String getMessage() {
        return this.message;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isRescuer() {
        return this.isRescuer;
    }

    @java.lang.SuppressWarnings("all")
    public Date getTimeStamp() {
        return this.timeStamp;
    }

    @java.lang.SuppressWarnings("all")
    public void setId(final long id) {
        this.id = id;
    }

    @java.lang.SuppressWarnings("all")
    public void setRescueId(final long rescueId) {
        this.rescueId = rescueId;
    }

    @java.lang.SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    public void setMessage(final String message) {
        this.message = message;
    }

    @java.lang.SuppressWarnings("all")
    public void setRescuer(final boolean isRescuer) {
        this.isRescuer = isRescuer;
    }

    @java.lang.SuppressWarnings("all")
    public void setTimeStamp(final Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ChatMessage)) return false;
        final ChatMessage other = (ChatMessage) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getRescueId() != other.getRescueId()) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$message = this.getMessage();
        final java.lang.Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        if (this.isRescuer() != other.isRescuer()) return false;
        final java.lang.Object this$timeStamp = this.getTimeStamp();
        final java.lang.Object other$timeStamp = other.getTimeStamp();
        if (this$timeStamp == null ? other$timeStamp != null : !this$timeStamp.equals(other$timeStamp)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ChatMessage;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final long $rescueId = this.getRescueId();
        result = result * PRIME + (int) ($rescueId >>> 32 ^ $rescueId);
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        result = result * PRIME + (this.isRescuer() ? 79 : 97);
        final java.lang.Object $timeStamp = this.getTimeStamp();
        result = result * PRIME + ($timeStamp == null ? 43 : $timeStamp.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "ChatMessage(id=" + this.getId() + ", rescueId=" + this.getRescueId() + ", name=" + this.getName() + ", message=" + this.getMessage() + ", isRescuer=" + this.isRescuer() + ", timeStamp=" + this.getTimeStamp() + ")";
    }
}
