package com.LucasVicentee.dslist.repositories;

import com.LucasVicentee.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> { //Extendendo as características do JPA, passando como valor a classe que será utilizada para as consultas padrões e o tipo do Identificador que será utilizado para o reconhecimento do Game

    @Modifying //Utiliza-se quando não é um SELECT e sim um UPDATE, DELETE ou um INSERT na base de dados
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
