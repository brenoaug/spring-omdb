package br.com.alura.screenmatch.service;

public interface IConverteDados {
    <T> T obterDadosSerie(String json, Class<T> classe);

    <T> T obterDadosEpisodio(String json, Class<T> classe);

}
