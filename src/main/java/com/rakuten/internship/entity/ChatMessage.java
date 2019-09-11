package com.rakuten.internship.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;

@Data
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long rescueId;

    private String name;

    private String message;

    private boolean isHelper;

    private Date timeStamp;

    @PrePersist
    private void onPrePersist() {
        if (timeStamp == null) {
            timeStamp = new Date();
        }
    }
}
