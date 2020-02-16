package com.rajkonkret.gifs.controller;

import com.rajkonkret.gifs.model.Category;
import com.rajkonkret.gifs.model.Gif;
import com.rajkonkret.gifs.repository.CategoryRepository;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoriesController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String allCategories(ModelMap modelMap) {
        // wyciągnięcie wartości
        List<Category> categoryList = categoryRepository.getAllCategories();
        //przekazanie do view
        modelMap.put("categories", categoryList);
        // zwrócenie widoku
        return "categories";

    }

    @GetMapping("/category/{id}")
    public String getGifsByCategory(@PathVariable int id, ModelMap modelMap) {
        // wyciągnięcie wartości
        List<Gif> gifs = gifRepository.findAllByCategoryId(id);
        // List<Category> categoryList = categoryRepository.getAllCategories();
        //przekazanie do view
        Category category = categoryRepository.getById(id);
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        // zwrócenie widoku
        return "category";

    }
}
