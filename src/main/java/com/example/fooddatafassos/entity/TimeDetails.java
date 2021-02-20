package com.example.fooddatafassos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeDetails {

    private String startTime;
    private boolean isOpenNow;
    private String closeTime;

}
