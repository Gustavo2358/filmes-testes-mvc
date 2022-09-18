package com.example.filmes.domain.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmeDTO {

    private String nome;
    private String genero;
    @JsonProperty("ano_lancamento")
    private String anoLancamento;
    @JsonProperty("atores_id")
    private List<Long> atoresId;

}
