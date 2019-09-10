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

    /**
     * <p>
     * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
     * c = 2 ⋅ atan2( √a, √(1−a) )
     * d = R ⋅ c
     *
     * @param latitude  緯度
     * @param longitude 経度
     * @return distance(km)
     */
    public double getDistance(final double latitude, final double longitude) {
        final double radius = 6371;
        final double latitudeDelta = this.latitude - latitude;
        final double longitudeDelta = this.longitude - longitude;

        final double sinOfLatitudeDelta = Math.sin(latitudeDelta / 2);
        final double sinOfLongitudeDelta = Math.sin(longitudeDelta / 2);

        final double a = Math.pow(sinOfLatitudeDelta, 2) + Math.cos(latitude) * Math.cos(this.latitude) * Math.pow(sinOfLongitudeDelta, 2);
        final double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return radius * b;
    }
}
