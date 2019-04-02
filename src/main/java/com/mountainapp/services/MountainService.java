package com.mountainapp.services;

import com.mountainapp.mappers.MountainMapper;
import com.mountainapp.models.Mountain;
import com.mountainapp.models.dtos.MountainDto;
import com.mountainapp.repositories.MountainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MountainService {

    private MountainRepository mountainRepository;

    private MountainMapper mountainMapper;

    public MountainService(MountainRepository mountainRepository, MountainMapper mountainMapper) {
        this.mountainRepository = mountainRepository;
        this.mountainMapper = mountainMapper;
    }

    public List<Mountain> getMountains(){
        return mountainRepository.findAll();
    }

    public List<MountainDto> getMountainsDto() {
        return mountainRepository
                .findAll()
                .stream()
                .map(mountainMapper::map)
                .collect(Collectors.toList());
    }

    public Mountain addMountain(MountainDto mountainDto){
        return mountainRepository.save(mountainMapper.reverseMap(mountainDto));
    }

    public void updateMountain(MountainDto mountainDto){
        mountainRepository
                .findMountainByMountainName(mountainDto.getMountainName())
                .ifPresent(m -> {
                    m.setHeightAboveSeaLevel(mountainDto.getHeightAboveSeaLevel());
                    m.setLengthOfTheMountainRange(mountainDto.getLengthOfTheMountainRange());
                    m.setMountainImage(mountainDto.getMountainImage());
                    m.setMountainInfo(mountainDto.getMountainInfo());
                    m.setMountainType(mountainDto.getMountainType());
                    m.setMountainRange(mountainDto.getMountainRange());
                    m.setMountainName(mountainDto.getMountainName());

                    mountainRepository.save(m);
                });
        }
        public void deleteMountain(String mountainName){
        mountainRepository.deleteMountainByMountainName(mountainName);

        }
}
