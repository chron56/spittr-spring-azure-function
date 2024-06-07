package com.spittr.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="SPITTLES_TABLE")
public class Spittle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String message;

    @Column(name="time_submitted")
    private LocalDateTime timeSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spitter.id")
    private Spitter spitter;

    public Spittle(){}

    public Spittle(int id, String message, LocalDateTime timeSubmitted, Spitter spitter) {
        this.id = id;
        this.message = message;
        this.timeSubmitted = timeSubmitted;
        this.spitter = spitter;
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

    public LocalDateTime getTimeSubmitted() {
        return timeSubmitted;
    }

    public void setTimeSubmitted(LocalDateTime timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spittle{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", timeSubmitted=").append(timeSubmitted);
        sb.append(", spitter=").append(spitter);
        sb.append('}');
        return sb.toString();
    }
}