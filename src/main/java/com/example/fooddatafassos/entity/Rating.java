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
public class Rating {

    private String  aggregateRating;
    private String text;
}

