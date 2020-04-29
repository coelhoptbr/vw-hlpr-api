package com.coelhoptbr.vw.dto;

import com.coelhoptbr.vw.bean.MyGeoPoint;
import com.google.cloud.firestore.GeoPoint;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Setter
public class InCoordinateDTO {

    @NotEmpty
    private String plate;

    private MyGeoPoint location;

    public InCoordinateDTO() {
        this.location = new MyGeoPoint(0, 0);
    }

    public String getPlate() {
        return plate;
    }

    public GeoPoint getLocation() {
        return new GeoPoint(location.getLatitude(), location.getLongitude());
    }
}
