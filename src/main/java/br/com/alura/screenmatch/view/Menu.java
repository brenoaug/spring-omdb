package br.com.alura.screenmatch.view;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ConsumoAPI consumoAPI;
    private final Scanner sc = new Scanner(System.in);
    private final ConverteDados conversor = new ConverteDados();

    public void pegandoAApiKeyDoUsuario() {
        System.out.println("Para comerçarmos, precisamos da sua API Key");
        String apiKey = sc.nextLine();
        consumoAPI =  new ConsumoAPI(apiKey);
    }

    public void buscarSerie() {
        System.out.println("Digite o nome do Serie: ");
        String nomeDaSerie = sc.nextLine().replace(" ", "+").toLowerCase();

        var dadosDaSerie = consumoAPI.obterDadosSerie(nomeDaSerie);

        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie, DadosSerie.class);
        System.out.println(dadosSerie);
    }

    public void buscarEpisodio() {
        System.out.println("Digite o nome da Serie: ");
        String nomeDaSerie = sc.nextLine().replace(" ", "+");

        System.out.println("Digite o numero da Temporada: ");
        int numeroDaTemporada = sc.nextInt();

        System.out.println("Digite o numero do Episodio: ");
        int numeroDoEpisodio = sc.nextInt();

        var dadosDoEpisodio = consumoAPI.obterDadosEpisodio(nomeDaSerie, numeroDaTemporada, numeroDoEpisodio);
        DadosEpisodio dadosEpisodio = conversor.obterDadosSerie(dadosDoEpisodio, DadosEpisodio.class);
        System.out.println(dadosEpisodio);
    }

    public void buscarTemporada() {
        System.out.println("Digite o nome da Serie: ");
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");

        System.out.println("Digite o numero da Temporada: ");
        int numeroDaTemporada = sc.nextInt();

        var dadosDaTemporada = consumoAPI.obterDadosTemporada(nomeDaSerie, numeroDaTemporada);
        DadosTemporada dadosTemporada = conversor.obterDadosSerie(dadosDaTemporada,  DadosTemporada.class);
        System.out.println(dadosTemporada);
    }

    public void buscarTodasTemporadas() {
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");
        System.out.println("Digite o numero da Temporada: ");

        List<DadosTemporada> temporadas = new ArrayList<>();
        int i = 1;

        var dadosDaSerie = consumoAPI.obterDadosSerie(nomeDaSerie);

        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie, DadosSerie.class);
        while (i <= dadosSerie.totalTemporadas()) {
            var listaTemporada = consumoAPI.obterDadosTemporada("breaking+bad", i);
            DadosTemporada dadosTemporadas = conversor.obterDadosSerie(listaTemporada, DadosTemporada.class);
            temporadas.add(dadosTemporadas);
            i++;
        }

        temporadas.forEach(System.out::println);
    }
}
