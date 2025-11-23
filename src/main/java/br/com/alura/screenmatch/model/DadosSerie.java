package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String tituloSerie,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("Year") String anoDeExibicao) {
}
