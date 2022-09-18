package com.example.filmes.repository;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Filme findByNome(String nome);

    List<Filme> findByGenero(String genero);

    List<Filme> findByAnoLancamento(String ano);

    List<Filme> findByAtores_Nome(String ator);


}
