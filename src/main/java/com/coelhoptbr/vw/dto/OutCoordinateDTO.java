package com.coelhoptbr.vw.dto;

import com.google.cloud.firestore.GeoPoint;
import lombok.*;

/**
 *
 * @author rodrigo
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class OutCoordinateDTO {

    private String plate;

    private GeoPoint location;

}
