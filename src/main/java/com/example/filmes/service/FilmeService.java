package com.example.filmes.service;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.Filme;
import com.example.filmes.domain.dto.FilmeDTO;
import com.example.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmeService {

    FilmeRepository filmeRepository;
    AtorService atorService;


    public List<Filme> getMovies(){
        return filmeRepository.findAll();

    }

    public Filme saveMovie(FilmeDTO filmeDTO){
        List<Ator> atores = atorService.findAllById(filmeDTO.getAtoresId());
        Filme filme = new Filme(filmeDTO.getNome(), filmeDTO.getGenero(), filmeDTO.getAnoLancamento());
        filme.getAtores().addAll(atores);
        atores.forEach(ator -> ator.getFilmes().add(filme));
        return filmeRepository.save(filme);
    }

    public Filme getMoviesByNome(String nome) {
        return filmeRepository.findByNome(nome);
    }

    public List<Filme> getMoviesByGenero(String genero) {
        return filmeRepository.findByGenero(genero);
    }

    public List<Filme> getMoviesByAnoLancamento(String ano) {
        return filmeRepository.findByAnoLancamento(ano);
    }

    public List<Filme> getMoviesByAtor(String ator) {
        return filmeRepository.findByAtores_Nome(ator);
    }

}
