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
public class OrderDetails {

    private String deliveryTime;
    private String promoOffers;
    private ActionInfo actionInfo;

}


