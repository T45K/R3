package com.rakuten.internship.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Rescue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float latitude;

    @Column(nullable = false)
    private float longitude;

    // TODO file upload
    private String image;

    private boolean isSolved;
}
