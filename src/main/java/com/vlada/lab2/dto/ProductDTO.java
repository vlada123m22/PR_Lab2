package com.vlada.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    private Long activityId;
    private String name;
    private String price;
    private String characteristics;

}
