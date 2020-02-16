package com.rajkonkret.gifs.controller;

import com.rajkonkret.gifs.model.Gif;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/")
    // @ResponseBody -  nie potrzebujemy bo już zwracamy stronę
    public String response(ModelMap modelMap) {
        //wyciągnięcie gifów
        Iterable<Gif> gifList = gifRepository.findAll();
        //przekazanie do warstwy widoku
        modelMap.put("gifs", gifList);
        //Zwrócenie
        return "home";
    }

//    @GetMapping("/showgifsinbrowser")
//    @ResponseBody
//    public String showGifs() {
//
//        return gifRepository.getGifsNames();
//    }

    @GetMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap) {
        // wyciągnięcie wartości
        List<Gif> favouritesGifs = gifRepository.findAll();
        List<Gif> fGifs= favouritesGifs.stream()
//                //.filter( s -> s.getFavorite()==true).collect(Collectors.toList());}
                .filter( s -> s.getFavorite()).collect(Collectors.toList());;
        //przekazanie do view
        modelMap.put("gifs", fGifs);
        // zwrócenie widoku
        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String getGifByName(@PathVariable String name, ModelMap modelMap){
        Optional<Gif> g = gifRepository.findByName(name);
        if (g.isPresent()){
        modelMap.put("gif", g.get());
        }
        System.out.println(g.get().getName());

        return "gif-details";
    }


}
