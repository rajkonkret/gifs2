package com.rajkonkret.gifs.controller;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    GifRepository gifRepository;
    @GetMapping("/")
    @ResponseBody
    public String response(){

        return "OK";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifs() {
        return gifRepository.getGifsNames();

    }



}
