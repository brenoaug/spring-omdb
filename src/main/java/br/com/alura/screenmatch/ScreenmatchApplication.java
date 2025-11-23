package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
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
        var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDadosSerie("gilmore+girls");
        var json2 = consumoAPI.obterDadosEpisodio("gilmore+girls", 1, 2);


        ConverteDados converteDados = new ConverteDados();
        DadosSerie dadosSerie = converteDados.obterDadosSerie(json,
                DadosSerie.class);
        System.out.println(dadosSerie);

        ConverteDados converteDadosEpisodio = new ConverteDados();
        DadosEpisodio dadosEpisodio = converteDadosEpisodio.obterDadosEpisodio(json2,
                DadosEpisodio.class);
        System.out.println(dadosEpisodio);
    }



}
