package com.mountainapp.controllers;

import com.mountainapp.models.Mountain;
import com.mountainapp.models.dtos.MountainDto;
import com.mountainapp.services.MountainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MountainController {

    private MountainService mountainService;

    public MountainController(MountainService mountainService) {
        this.mountainService = mountainService;
    }

    @GetMapping("/mountains")
    public List<Mountain> getMountains() {
        return mountainService.getMountains();

    }


    @GetMapping("/dto/mountains")
    public List<MountainDto> getMountainsDto() {
        return mountainService.getMountainsDto();

    }

    @PostMapping("/dto/mountains")
    public Mountain addMountain(@RequestBody MountainDto mountainDto){
           return mountainService.addMountain(mountainDto);
    }
    //@PostMapping("/dto/mountains")
    //public void updateMountain(@RequestBody MountainDto mountainDto){
      //  mountainService.updateMountain(mountainDto);
    //}
    @DeleteMapping("/dto/mountains/{mountainName}")
    public void deleteMountain(@PathVariable String mountainName){
        mountainService.deleteMountain(mountainName);
    }
}
