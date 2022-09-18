package com.example.filmes.controller;

import com.example.filmes.domain.Filme;
import com.example.filmes.domain.dto.FilmeDTO;
import com.example.filmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {

    FilmeService filmeService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Filme>> listMovies(){
        return new ResponseEntity<>(filmeService.getMovies(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Filme> postMovie(@RequestBody FilmeDTO filmeDTO){
        Filme filmeResponse =  filmeService.saveMovie(filmeDTO);
        return new ResponseEntity<>(filmeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/nome")
    public ResponseEntity<Filme> getMoviesByNome(@RequestParam String nome){
        return new ResponseEntity<>(filmeService.getMoviesByNome(nome), HttpStatus.OK);
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Filme>> getMoviesByGenero(@RequestParam String genero){
        return new ResponseEntity<>(filmeService.getMoviesByGenero(genero), HttpStatus.OK);
    }

    @GetMapping("/ano")
    public ResponseEntity<List<Filme>> getMoviesByAnoLancamento(@RequestParam String ano){
        return new ResponseEntity<>(filmeService.getMoviesByAnoLancamento(ano), HttpStatus.OK);
    }

    @GetMapping("/ator")
    public ResponseEntity<List<Filme>> getMoviesByAtor(@RequestParam String ator){
        return new ResponseEntity<>(filmeService.getMoviesByAtor(ator), HttpStatus.OK);
    }

}
