package com.mountainapp.controllers;

import com.mountainapp.commons.extras.CreatorXLS;
import com.mountainapp.models.dtos.MountainDto;
import com.mountainapp.services.MountainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    private MountainService mountainService;

    public HomeController(MountainService mountainService) {
        this.mountainService = mountainService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("mountains", mountainService.getMountainsDto());
        return "index";
    }

    @GetMapping("/mountains")
    public String mountainPage(Model model){
        model.addAttribute("mountains", mountainService.getMountainsDto());
        return "mountains";
    }
    @GetMapping("/delete")
    public String deleteMountain(@RequestParam(value = "mountain") String mountainName){
        mountainService.deleteMountain(mountainName);
        return "redirect:/mountains";
    }
    @PostMapping("/addMountain")
    public String addMountain(@ModelAttribute MountainDto mountain){
        mountainService.addMountain(mountain);
        return "redirect:/mountains";
    }
    @GetMapping("/excel")
    public String createFile() throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        CreatorXLS<MountainDto> creatorXLS = new CreatorXLS<>(MountainDto.class);
        creatorXLS.creataFile(mountainService.getMountainsDto(), "src/main/resources", "mountains");
        return "redirect:/";

    }
}