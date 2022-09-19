package com.example.filmes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "atores_filmes",
            joinColumns = @JoinColumn(name = "ator_id"),
            inverseJoinColumns = @JoinColumn(name = "filme_id"))
    private List<Filme> filmes = new ArrayList<>();

    public Ator(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ator)) return false;
        Ator ator = (Ator) o;
        return Objects.equals(nome, ator.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
