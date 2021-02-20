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
@Document(collection = "dish")
public class DishData {

    @Id
    private String id;
    private String name;
    private String category;
    private String partner_id;
    private boolean isVeg;
    private boolean isNonveg;
    private boolean isEgg;
    private Double price;
    private String bigDescription;
    private String smallDescription;
    private String cuizine;
    private String image_link;
    private boolean isPopular;
    private boolean isRecommended;
    private boolean bestSeller;
    private List<Tags> tags;
    private String restaurantId;
    private Double rating;
    private String variant;

}


