package com.LucasVicentee.dslist.dto;

import com.LucasVicentee.dslist.entities.Game;
import com.LucasVicentee.dslist.projections.GameMinProjection;

public class GameMinDTO { //Versão do Game, porém com os dados que preciso

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {

    }

    public GameMinDTO(Game entity) { //Pegando a classe Game para puxar os campos usados lá
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) { //Pegando a classe Game para puxar os campos usados lá
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    //No DTO se utiliza apenas Getters e nao tem Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
