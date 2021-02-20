package com.example.fooddatafassos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

    private String product_id;
    private Integer brand_id;
    private String product_name;
    private Double price;
    private Double offer_price;
    private String product_imageUrl;
    private String image_es;
    private String benefits;
    private Integer sure_points;
    private String small_description;
    private String big_description;
    private Integer is_veg;
    private Integer is_customizable;
    private Integer customization_limit;
    private Integer spice_level;
    private Integer is_back_calculate_tax;
    private Integer tax_category;
    private Integer is_featured;
    private Integer is_available;
    private Integer bought_count;
    private Double rating;
    private Integer preparation_time;
    private Integer sequence;
    private Integer display_type;
    private List<Tags> tags;
    private Double display_price;

}
