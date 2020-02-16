package com.rajkonkret.gifs.repository;

import com.rajkonkret.gifs.model.Category;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Data
public class CategoryRepository {
    private static List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category("sport", 0),
            new Category("it", 1),
            new Category("smile", 2)
    );

    public Category getById(int id) {
        return ALL_CATEGORIES.stream()
                .filter(s -> s.getId() == id)
                .findAny().get();
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

}
