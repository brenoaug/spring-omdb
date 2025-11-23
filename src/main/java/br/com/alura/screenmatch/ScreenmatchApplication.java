package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(@SuppressWarnings("NullableProblems") String[] args) {
        var consumoAPI = new ConsumoAPI();
        var dadosDaSerie = consumoAPI.obterDadosSerie("breaking+bad");
        var dadosDoEpisodio = consumoAPI.obterDadosEpisodio("breaking+bad", 1, 2);
        var dadosDaTemporada = consumoAPI.obterDadosTemporada("breaking+bad", 2);

        ConverteDados conversor = new ConverteDados();

        DadosSerie dadosSerie = conversor.obterDadosSerie(dadosDaSerie,
                DadosSerie.class);
        System.out.println(dadosSerie);

        DadosTemporada dadosTemporada = conversor.obterDadosSerie(dadosDaTemporada,
                DadosTemporada.class);
        System.out.println(dadosTemporada);

        DadosEpisodio dadosEpisodio = conversor.obterDadosSerie(dadosDoEpisodio,
                DadosEpisodio.class);
        System.out.println(dadosEpisodio);


        List<DadosTemporada> temporadas = new ArrayList<>();
        int i = 1;

        while (i <= dadosSerie.totalTemporadas()) {
            var listaTemporada = consumoAPI.obterDadosTemporada("breaking+bad", i);
            DadosTemporada dadosTemporadas = conversor.obterDadosSerie(listaTemporada, DadosTemporada.class);
            temporadas.add(dadosTemporadas);
            i++;
        }

        temporadas.forEach(System.out::println);
    }

}
