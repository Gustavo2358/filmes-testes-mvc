package com.example.filmes.service;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.Filme;
import com.example.filmes.domain.dto.FilmeDTO;
import com.example.filmes.repository.AtorRepository;
import com.example.filmes.repository.FilmeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class FilmeServiceTeste {

    @Autowired
    FilmeService filmeService;
    @Autowired
    FilmeRepository filmeRepository;
    @Autowired
    AtorRepository atorRepository;
    @Autowired
    AtorService atorService;

    @BeforeEach
    public void limpaBanco() {
        filmeRepository.deleteAll();
    }

    @Test
    public void insereAtores(){
        Ator mark = new Ator("Mark Hammil");
        Ator carrie = new Ator("Carrie Fisher");
        atorRepository.saveAll(Arrays.asList(mark,carrie));

        List<Ator> atores = atorService.findAll();
        Assertions.assertEquals(2, atores.size());
    }

    @Test
    public void testaInsereNoBanco(){
        FilmeDTO starWars = new FilmeDTO("Star Wars", "Sci-fi", "1977", Arrays.asList(1L, 2L));
        filmeService.saveMovie(starWars);

        List<Filme> filmes = filmeService.getMovies();

        Assertions.assertEquals(1, filmes.size());
        Assertions.assertEquals("Star Wars", filmes.get(0).getNome());
        Assertions.assertEquals("1977", filmes.get(0).getAnoLancamento());
    }

    @Test
    public void getMoviesByNome(){
        FilmeDTO starWars = new FilmeDTO("Star Wars", "Sci-fi", "1977", Arrays.asList(1L, 2L));
        FilmeDTO BladeRunner = new FilmeDTO("Blade Runner", "Sci-fi", "1982", Collections.emptyList());
        filmeService.saveMovie(starWars);
        filmeService.saveMovie(BladeRunner);

        List<Filme> filmes = filmeService.getMovies();
        Assertions.assertEquals(2, filmes.size());

        Filme filmeByNome = filmeService.getMoviesByNome("Star Wars");
        Assertions.assertEquals("Star Wars", filmeByNome.getNome());
    }

    @Test
    public void getMoviesByGenero(){
        FilmeDTO starWars = new FilmeDTO("Star Wars", "Sci-fi", "1977", Arrays.asList(1L, 2L));
        FilmeDTO BladeRunner = new FilmeDTO("Blade Runner", "Sci-fi", "1982", Collections.emptyList());
        filmeService.saveMovie(starWars);
        filmeService.saveMovie(BladeRunner);

        List<Filme> filmes = filmeService.getMovies();
        Assertions.assertEquals(2, filmes.size());

        List<Filme> filmesByGenero = filmeService.getMoviesByGenero("Sci-fi");
        Assertions.assertEquals(2, filmesByGenero.size());
        Assertions.assertEquals("Star Wars", filmesByGenero.get(0).getNome());
        Assertions.assertEquals("Blade Runner", filmesByGenero.get(1).getNome());
    }

    @Test
    public void getMoviesByAnoLancamento(){
        FilmeDTO Rambo = new FilmeDTO("Rambo", "Action", "1982", Collections.emptyList());
        FilmeDTO BladeRunner = new FilmeDTO("Blade Runner", "Sci-fi", "1982", Collections.emptyList());
        filmeService.saveMovie(Rambo);
        filmeService.saveMovie(BladeRunner);

        List<Filme> filmes = filmeService.getMovies();
        Assertions.assertEquals(2, filmes.size());

        List<Filme> filmesByGenero = filmeService.getMoviesByAnoLancamento("1982");
        Assertions.assertEquals(2, filmesByGenero.size());
        Assertions.assertEquals("Rambo", filmesByGenero.get(0).getNome());
        Assertions.assertEquals("Blade Runner", filmesByGenero.get(1).getNome());
    }
}
