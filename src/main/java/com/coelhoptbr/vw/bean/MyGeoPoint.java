package com.coelhoptbr.vw.bean;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class MyGeoPoint implements Serializable {

    private static final long serialVersionUID = -99127398709809L;

    private double latitude;
    private double longitude;

    public MyGeoPoint() {
        this.setLatitude(0);
        this.setLongitude(0);
    }
}
