package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    private final HttpClient client = HttpClient.newHttpClient();

    private final String apiOmdb;

    public ConsumoAPI() {
        this.apiOmdb = System.getenv("OMDB_API_KEY");
        if (apiOmdb == null || apiOmdb.isBlank()) {
            throw new IllegalStateException("Variável de ambiente OMDB_API_KEY não definida");
        }
    }

    public String obterDados(String serie, int season) {
        String baseUrl = "http://www.omdbapi.com/?t=";
        String urlComplete = serie + "&Season=" + season + "&apikey=" + apiOmdb;


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + urlComplete))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
