package com.LucasVicentee.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //Configura a classe Java para que seja equivalente a uma tabela do banco relacional
@Table(name = "tb_game")//Opcional, caso queira mudar o nome da tabela no banco de dados (Caso não quiser apenas não deixe esta anotação)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Faz com que o ID seja autoincrement pelo banco
    private Long id;
    private String title;

    @Column(name = "game_year") //Alterando o nome da coluna na tabela, pois o nome year pode dar conflito com o banco, por ser uma palavra reservada
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") //Adicionando mais do que 255 caracteres que é o padrão do String
    private String shortDescription;

    @Column(columnDefinition = "TEXT") //Adicionando mais do que 255 caracteres que é o padrão do String
    private String longDescription;

    public Game() {

    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Game game)) return false;
        return Objects.equals(id,
                game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
