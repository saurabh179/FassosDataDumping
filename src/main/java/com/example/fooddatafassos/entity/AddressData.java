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
public class AddressData {

    private String landmark;
    private String city;
    private String locality;
    private String societyName;
    private String street;
}
