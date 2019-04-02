package com.mountainapp.mappers;


import com.mountainapp.commons.Mapper;
import com.mountainapp.models.Mountain;
import com.mountainapp.models.dtos.MountainDto;
import org.springframework.stereotype.Component;

@Component
public class MountainMapper implements Mapper<Mountain, MountainDto> {
    @Override
    public MountainDto map(Mountain from) {
        return MountainDto
                .builder()
                .mountainName(from.getMountainName())
                .mountainRange(from.getMountainRange())
                .heightAboveSeaLevel(from.getHeightAboveSeaLevel())
                .lengthOfTheMountainRange(from.getLengthOfTheMountainRange())
                .mountainType(from.getMountainType())
                .mountainImage(from.getMountainImage())
                .mountainInfo(from.getMountainInfo())
                .build();
    }

    @Override
    public Mountain reverseMap(MountainDto to) {
        return Mountain
                .builder()
                .mountainName(to.getMountainName())
                .mountainRange(to.getMountainRange())
                .heightAboveSeaLevel(to.getHeightAboveSeaLevel())
                .lengthOfTheMountainRange(to.getLengthOfTheMountainRange())
                .mountainType(to.getMountainType())
                .mountainImage(to.getMountainImage())
                .mountainInfo(to.getMountainInfo())
                .build();
    }
}
