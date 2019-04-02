package com.mountainapp.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MountainDto {


    private String mountainName;
    private String mountainRange;
    private String mountainType;
    private long lengthOfTheMountainRange;
    private long heightAboveSeaLevel;
    private String mountainImage;
    private String mountainInfo;

}
