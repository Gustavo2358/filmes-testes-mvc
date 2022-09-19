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
import java.util.List;

@SpringBootTest
public class AtorServiceTeste {

    @Autowired
    AtorRepository atorRepository;
    @Autowired
    AtorService atorService;

    @BeforeEach
    public void limpaBanco(){
        atorRepository.deleteAll();
    }

    @Test
    public void findAllByIdTeste(){
        Ator mark = new Ator("Mark Hammil");
        Ator carrie = new Ator("Carrie Fisher");
        atorService.saveActors(Arrays.asList(mark,carrie));

        List<Ator> atores = atorService.findAllById(Arrays.asList(1L, 2L));

        Assertions.assertEquals(2, atores.size());
        Assertions.assertEquals(1, atores.get(0).getId());
        Assertions.assertEquals("Mark Hammil", atores.get(0).getNome());

    }

    @Test
    public void insereAtores(){
        Ator mark = new Ator("Mark Hammil");
        Ator carrie = new Ator("Carrie Fisher");
        atorService.saveActors(Arrays.asList(mark,carrie));

        List<Ator> atores = atorService.findAll();
        Assertions.assertEquals(2, atores.size());
        Assertions.assertEquals("Mark Hammil", atores.get(0).getNome());
    }

}
