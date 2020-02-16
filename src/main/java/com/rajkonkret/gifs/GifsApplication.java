package com.rajkonkret.gifs;

import com.rajkonkret.gifs.model.Gif;
import com.rajkonkret.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GifsApplication implements CommandLineRunner {

    @Autowired
    GifRepository gifRepository;

    @Override
    public void run(String... args) throws Exception {

        gifRepository.save(new Gif("android-explosion", "mols", true, 1));
        gifRepository.save(new Gif("ben-and-mike", "mika", true, 2));
        gifRepository.save(new Gif("book-dominos", "mem", true, 0));
        gifRepository.save(new Gif("compiler-bot", "bot", true, 1));
        gifRepository.save(new Gif("cowboy-coder", "code", true, 1));
        gifRepository.save(new Gif("infinite-andrew", "andrew", false, 2));


    }

    public static void main(String[] args) {
        SpringApplication.run(GifsApplication.class, args);
    }


}
