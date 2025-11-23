package br.com.alura.screenmatch;

import br.com.alura.screenmatch.view.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(@SuppressWarnings("NullableProblems") String[] args) {
        Menu menu = new Menu();
        menu.pegandoAApiKeyDoUsuario();
//        menu.buscarSerie();
//        System.out.println(" ");
//        menu.buscarTodasTemporadas();
//        System.out.println(" ");
//        menu.buscarEpisodio();
        menu.buscarTodosEpisodios();

//
//
//
//
//
//
//
//        var consumoAPI = new ConsumoAPI();
//        var dadosDaSerie = consumoAPI.obterDadosSerie("breaking+bad", "4a9e184a");
//        var dadosDoEpisodio = consumoAPI.obterDadosEpisodio("breaking+bad", 1, 2, "4a9e184a");
//        var dadosDaTemporada = consumoAPI.obterDadosTemporada("breaking+bad", 2, "4a9e184a");
//
//        ConverteDados conversor = new ConverteDados();
//
//        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie,
//                DadosSerie.class);
//        System.out.println(dadosSerie);
//
//        DadosTemporada dadosTemporada = conversor.obterDadosSerie(dadosDaTemporada,
//                DadosTemporada.class);
//        System.out.println(dadosTemporada);
//
//        DadosEpisodio dadosEpisodio = conversor.obterDadosSerie(dadosDoEpisodio,
//                DadosEpisodio.class);
//        System.out.println(dadosEpisodio);
//


//        List<DadosTemporada> temporadas = new ArrayList<>();
//        int i = 1;
//
//        while (i <= dadosSerie.totalTemporadas()) {
//            var listaTemporada = consumoAPI.obterDadosTemporada("breaking+bad", i, "4a9e184a");
//            DadosTemporada dadosTemporadas = conversor.obterDadosSerie(listaTemporada, DadosTemporada.class);
//            temporadas.add(dadosTemporadas);
//            i++;
//        }
//
//        temporadas.forEach(System.out::println);


    }

}
