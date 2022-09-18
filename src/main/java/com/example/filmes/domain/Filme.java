package com.example.filmes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    @JsonProperty("ano_lancamento")
    private String anoLancamento;

    @JsonManagedReference
    @ManyToMany(mappedBy = "filmes")
    @JsonIgnore
    private List<Ator> atores = new ArrayList<>();


    public Filme(String nome, String genero, String anoLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
}
