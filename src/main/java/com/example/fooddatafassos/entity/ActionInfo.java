package com.example.fooddatafassos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ActionInfo {

    private String orderNow;
    private String clickUrl;
    private String deliveryCharges;
}