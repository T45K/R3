package com.rakuten.internship.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class RescueTest {

    @Test
    public void doNothing() {
        return;
    }

    @Test
    public void verifyDistance() {
        Rescue sut = new Rescue();
        sut.setLatitude(35.622975f);
        sut.setLongitude(139.7754967f);

        assertEquals(395.9, sut.getDistance(34.80583, 135.5339813f), 2.0f);
        // Unicorn: 35.622975,139.7754967,17.12z
        // 395.9km
        // Odaiba: 34.8058262,135.5339813,19.4z
    }
}
