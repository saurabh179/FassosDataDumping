package com.example.fooddatafassos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FassosData {

    private Integer delivery_locality_id;
    private Integer city_id;
    private String city_name;
    private String landmark;
    private Double latitude;
    private Double longitude;
    private String locality_name;
    private String society_name;
    private String street;
    private Integer store_id;
    private Integer parent_store_id;
    private String store;
    private boolean status;
    private String onTime;
    private String offTime;
    private String message;
    private String formattedAddress;
    private Integer tax;
    private String place_name;
    private Country country;


}
