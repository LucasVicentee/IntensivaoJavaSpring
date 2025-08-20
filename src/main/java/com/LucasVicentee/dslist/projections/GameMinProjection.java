package com.LucasVicentee.dslist.projections;

public interface GameMinProjection {

    //Passa todos os parametros da consulta personalizada
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
