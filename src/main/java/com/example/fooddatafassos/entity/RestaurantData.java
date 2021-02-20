package com.example.fooddatafassos.entity;

import com.example.fooddatafassos.dto.Tags;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(value = "restaurant")
public class RestaurantData {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String city;
    private String deliveryPartner;
    private String imageUrl;
    private String cft;
    private String cfo;
    private LocationDetails location;
    private TimeDetails timing;
    private Rating rating;
    private OrderDetails orderDetails;
    private Tags tags;
    private List<String> restaurantMenu;


}
