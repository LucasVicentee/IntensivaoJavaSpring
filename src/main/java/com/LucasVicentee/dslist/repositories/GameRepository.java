package com.LucasVicentee.dslist.repositories;

import com.LucasVicentee.dslist.entities.Game;
import com.LucasVicentee.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> { //Extendendo as características do JPA, passando como valor a classe que será utilizada para as consultas padrões e o tipo do Identificador que será utilizado para o reconhecimento do Game

    //Consulta SQL personalizada e com o @Query, que significado que é uma consulta personalizada
    @Query(nativeQuery = true, value = """ 
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
