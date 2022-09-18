package com.example.filmes;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.Filme;
import com.example.filmes.repository.AtorRepository;
import com.example.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class FilmesApplication implements CommandLineRunner {

    private AtorRepository atorRepository;
    private FilmeRepository filmeRepository;

    public static void main(String[] args) {
        SpringApplication.run(FilmesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Ator mark = new Ator("Mark Hammil");
        Ator carrie = new Ator("Carrie Fisher");

        Filme starWars = new Filme("Star Wars", "Sci-fi", "1977");

        mark.getFilmes().add(starWars);
        carrie.getFilmes().add(starWars);
//        starWars.getAtores().addAll(Arrays.asList("Carrie Fisher", "Mark Hammil", "Harrison Ford"));

        filmeRepository.save(starWars);
        atorRepository.saveAll(Arrays.asList(mark, carrie));

    }
}
