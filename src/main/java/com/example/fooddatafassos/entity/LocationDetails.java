package com.example.fooddatafassos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDetails {

    private String lat;
    private String log;
    private AddressData address;
}

