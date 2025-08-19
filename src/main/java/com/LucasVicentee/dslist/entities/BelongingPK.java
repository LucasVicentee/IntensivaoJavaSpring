package com.LucasVicentee.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable //Encapsulando dois atributos em uma classe só
public class BelongingPK { //Criada essa classe auxiliar para o ID do banco, pois no modelo de dados não se pode ter duas referencias de id para apenas um tipo de dado

    @ManyToOne //Criação da relação de um para muitos
    @JoinColumn(name = "game_id") //Definindo o nome da coluna estrangeira
    private Game game;

    @ManyToOne //Criação da relação de um para muitos
    @JoinColumn(name = "list_id") //Definindo o nome da coluna estrangeira
    private GameList list;
    public BelongingPK() {

    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BelongingPK that)) return false;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
