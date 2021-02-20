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
public class FassosCollection {

    private String collection_id;
    private String collection_imageUrl;
    private String collection_name;
    private Integer sequence;
    private String small_description;
    private Integer is_elite;
    private List<Product> products;

}
