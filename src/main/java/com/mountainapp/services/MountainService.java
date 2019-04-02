package com.mountainapp.services;

import com.mountainapp.models.Mountain;
import com.mountainapp.repositories.MountainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MountainService {

    private MountainRepository mountainRepository;

    public MountainService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }
    public List<Mountain> getMountains(){
        return mountainRepository.findAll();
    }
}
