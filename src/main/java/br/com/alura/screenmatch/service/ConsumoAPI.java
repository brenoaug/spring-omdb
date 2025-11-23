package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    //private final String apiOmdb;
    private final String apiKeyUser;
    public ConsumoAPI(String apiKey) {
        this.apiKeyUser = apiKey;
        if (apiKeyUser == null || apiKeyUser.isBlank()) {
            throw new IllegalStateException("Variável de ambiente OMDB_API_KEY não definida");
        }
    }

    public String obterDadosSerie(String serie) {
        String host = "http://www.omdbapi.com/?";
        String title = "t=" + serie;
        String apiKey = "&apikey=" + this.apiKeyUser;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + title + apiKey))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String obterDadosEpisodio(String serie, int numberSeason, int numberEpisode) {
        String host = "http://www.omdbapi.com/?";
        String title = "t=" + serie;
        String season = "&season=" + numberSeason;
        String episode = "&episode=" + numberEpisode;
        String apiKey = "&apikey=" + apiKeyUser;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + title + season + episode + apiKey))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String obterDadosTemporada(String serie, int numberSeason) {
        String host = "http://www.omdbapi.com/?";
        String title = "t=" + serie;
        String season = "&season=" + numberSeason;
        String apiKey = "&apikey=" + apiKeyUser;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + title + season + apiKey))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
