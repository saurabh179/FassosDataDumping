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
public class FassosGetStoreApiResponse {

    private Integer stateCode;
    private String stateMessage;
    private FassosData data;
}
