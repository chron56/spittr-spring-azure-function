package com.spittr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="spittle")
public class Spittle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    // Variable to store the message/description of the Spittle (post)
    private String message;

    // Variable to store the time that the Spittle was created
    @Column(name="time_submitted", columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
    private Timestamp timeSubmitted;

    @ManyToOne
    @JoinColumn(name = "spitter_id", insertable = false, updatable = false)
    @JsonIgnore
    private Spitter spitter;

    @Column(name = "spitter_id")
    private int spitterId;

    public Spittle(){}

    public Spittle(int id, String message, Timestamp timeSubmitted, Spitter spitter) {
        this.id = id;
        this.message = message;
        this.timeSubmitted = timeSubmitted;
        this.spitter = spitter;
        this.spitterId = spitter != null ? spitter.getId() : null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(Timestamp timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @JsonProperty("spitter_id")
    public int getSpitterId() {
        return spitterId;
    }

    public void setSpitterId(int spitterId) {
        this.spitterId = spitterId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spittle{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", timeSubmitted=").append(timeSubmitted);
        sb.append(", spitter=").append(spitter);
        sb.append(", spitterId=").append(spitterId);
        sb.append('}');
        return sb.toString();
    }
}