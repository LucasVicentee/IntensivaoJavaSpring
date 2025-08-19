package com.LucasVicentee.dslist.repositories;

import com.LucasVicentee.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> { //Extendendo as características do JPA, passando como valor a classe que será utilizada para as consultas padrões e o tipo do Identificador que será utilizado para o reconhecimento do Game

}
