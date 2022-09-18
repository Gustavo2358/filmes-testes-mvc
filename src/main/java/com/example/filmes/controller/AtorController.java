package com.example.filmes.controller;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.dto.AtorDTO;
import com.example.filmes.service.AtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atores")
@AllArgsConstructor
public class AtorController {

    AtorService atorService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<List<Ator>> postActors(@RequestBody List<AtorDTO> actorsDTO){
        List<Ator> actors = actorsDTO.stream().map(actor -> new Ator(actor.getNome())).collect(Collectors.toList());
        List<Ator> actorsResponse =  atorService.saveActors(actors);
        return new ResponseEntity<>(actorsResponse, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Ator>> findAllActors(){
        List<Ator> atores = atorService.findAll();
        return new ResponseEntity<>(atores, HttpStatus.OK);
    }
}
