package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(
        @JsonAlias("Season")
        Integer numeroTemporada,
        @JsonAlias("Title")
        String nomeSerie,
        @JsonAlias("totalSeasons")
        Integer totalTemporadas,
        @JsonAlias("Episodes")
        List<DadosEpisodio> listaEpisodios
        ) {

}

