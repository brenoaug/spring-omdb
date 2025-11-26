package br.com.alura.screenmatch.model;

public class Temporada {
    private String nomeSerie;
    private Integer numeroTemporada;
    private Integer totalTemporadas;
    private Integer numeroEpisodios;

    public Temporada(String nomeSerie, DadosTemporada dadosTemporada) {
        this.nomeSerie = nomeSerie;
        this.numeroTemporada = dadosTemporada.numeroTemporada();
        this.totalTemporadas = dadosTemporada.totalTemporadas();
        this.numeroEpisodios = dadosTemporada.listaEpisodios().size();
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Integer getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(Integer numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    @Override
    public String toString() {
        return
                "Nome da Série='" + nomeSerie + '\'' +
                        ", Total de Temporadas da Série= " + totalTemporadas +
                        ", a Temporada " + numeroTemporada +
                        " tem " + numeroEpisodios + " episódios.";
    }
}
