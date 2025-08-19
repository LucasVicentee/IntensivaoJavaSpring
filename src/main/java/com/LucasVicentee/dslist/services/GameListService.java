package com.LucasVicentee.dslist.services;

import com.LucasVicentee.dslist.dto.GameListDTO;
import com.LucasVicentee.dslist.entities.GameList;
import com.LucasVicentee.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired //Injeta a chamada de outra classe que está em outro pacote, assim cirando a ligação entre elas
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) //Assegura que não vai bloquear o banco para escrita, assim ficando mais rápido
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList(); //Transformando uma lista que era de Game para uma lista de GameListDTO (Ou seja, apenas aquilo que eu preciso)
    }
}
