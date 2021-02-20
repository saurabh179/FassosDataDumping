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
public class Country {

    private String iso_country_code;
    private String currency_symbol;
    private String currency_unicode;
    private String time_zone;
    private String dialing_code;
    private Integer mobile_number_length;
    private String country_code;
    private String time_diff;
    private String currency_code;

}
