package br.com.alura.screenmatch.view;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final ConverteDados conversor = new ConverteDados();
    private ConsumoAPI consumoAPI;


    public void pegandoAApiKeyDoUsuario() {
        System.out.println("Para comerçarmos, precisamos da sua API Key");
        String apiKey = sc.nextLine();
        consumoAPI = new ConsumoAPI(apiKey);
    }

    public void buscarSerie() {
        System.out.println("Digite o nome do Serie: ");
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");

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
        DadosTemporada dadosTemporada = conversor.obterDadosSerie(dadosDaTemporada, DadosTemporada.class);
        System.out.println(dadosTemporada);
    }

    public void buscarTodasTemporadasComTodosEpisodios() {
        System.out.println("Digite o nome da Serie: ");
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");

        var dadosDaSerie = consumoAPI.obterDadosSerie(nomeDaSerie);
        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie, DadosSerie.class);
//
        List<DadosTemporada> temporadas = IntStream.rangeClosed(1, dadosSerie.totalTemporadas())
                .mapToObj(n -> {
                    var listaTemporada = consumoAPI.obterDadosTemporada(nomeDaSerie, n);
                    return conversor.obterDadosSerie(listaTemporada, DadosTemporada.class);
                })
                .toList();

        temporadas.forEach(System.out::println);

    }

    public void buscarTodosEpisodios() {
        System.out.println("Digite o nome da Serie: ");
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");

        var dadosDaSerie = consumoAPI.obterDadosSerie(nomeDaSerie);
        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie, DadosSerie.class);

        List<DadosTemporada> temporadas = IntStream.rangeClosed(1, dadosSerie.totalTemporadas())
                .mapToObj(i -> conversor.obterDadosSerie(consumoAPI.obterDadosTemporada(nomeDaSerie, i), DadosTemporada.class))
                .toList();

        temporadas.forEach(t -> t.listaEpisodios().forEach(e -> System.out.println(e.tituloEpisodio())));
    }

    public void buscarMelhoresEpisodios() {
        System.out.println("Digite o nome da Serie: ");
        String nomeDaSerie = sc.nextLine().toLowerCase().replace(" ", "+");

        var dadosDaSerie = consumoAPI.obterDadosSerie(nomeDaSerie);

        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie, DadosSerie.class);

        List<DadosTemporada> temporadas = IntStream.rangeClosed(1, dadosSerie.totalTemporadas())
                .mapToObj(i -> conversor.obterDadosSerie(consumoAPI.obterDadosTemporada(nomeDaSerie, i), DadosTemporada.class))
                .toList();

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.listaEpisodios().stream())
                .toList();

        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equals("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao)
                        .reversed())
                .limit(5)
                .forEach(System.out::println);
    }
}
