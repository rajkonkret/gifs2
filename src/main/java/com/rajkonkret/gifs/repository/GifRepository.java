package com.rajkonkret.gifs.repository;

import com.rajkonkret.gifs.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GifRepository {
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explotion","mols",true, 1),
            new Gif("ben and mike","mika",true, 2),
            new Gif("book-dominos","mem",true, 0),
            new Gif("compiler-bot","bot",true, 1),
            new Gif("cowboy-coder","code",true, 1),
            new Gif("infinite-andrew","andrew",true, 2)
    );
    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public String getGifsNames(){
        return ALL_GIFS.stream().map(s -> s.getName()).collect(Collectors.joining(" , "));
    }
}
