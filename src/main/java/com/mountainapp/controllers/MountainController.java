package com.mountainapp.controllers;

import com.mountainapp.models.Mountain;
import com.mountainapp.services.MountainService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MountainController {

    private MountainService mountainService;

    public MountainController(MountainService mountainService){
        this.mountainService = mountainService;
    }

    @GetMapping("/mountains")
    public List<Mountain> getMountains(){
        return mountainService.getMountains();

    }
}
