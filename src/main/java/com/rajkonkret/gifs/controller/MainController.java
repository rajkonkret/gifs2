package com.rajkonkret.gifs.controller;

import com.rajkonkret.gifs.model.Gif;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/")
    // @ResponseBody -  nie potrzebujemy bo już zwracamy stronę
    public String response(ModelMap modelMap) {
        //wyciągnięcie gifów
        List<Gif> gifList = gifRepository.getAllGifs();
        //przekazanie do warstwy widoku
        modelMap.put("gifs", gifList);
        //Zwrócenie
        return "home";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifs() {
        return gifRepository.getGifsNames();
    }

    @GetMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap) {
        // wyciągnięcie wartości
        List<Gif> favouritesGifs = gifRepository.getAllFavoritesGifs();
        //przekazanie do view
        modelMap.put("gifs", favouritesGifs);
        // zwrócenie widoku
        return "favorites";
    }


}
