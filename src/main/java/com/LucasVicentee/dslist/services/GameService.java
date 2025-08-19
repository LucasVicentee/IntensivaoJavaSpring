package com.LucasVicentee.dslist.services;

import com.LucasVicentee.dslist.dto.GameDTO;
import com.LucasVicentee.dslist.dto.GameMinDTO;
import com.LucasVicentee.dslist.entities.Game;
import com.LucasVicentee.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; //Faz a mesma coisa que o service, basicamente acopla a classe ao projeto do framework
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired //Injeta a chamada de outra classe que está em outro pacote, assim cirando a ligação entre elas
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //Assegura que não vai bloquear o banco para escrita, assim ficando mais rápido
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //Transformando uma lista que era de Game para uma lista de GameMinDTO (Ou seja, apenas aquilo que eu preciso)
        return dto;
    }

    @Transactional(readOnly = true) //Assegura que não vai bloquear o banco para escrita, assim ficando mais rápido
    public GameDTO findByID(Long id) {
        Game result = gameRepository.findById(id).get(); //Pegando o id da classe Game
        GameDTO dto = new GameDTO(result); //Convertendo para GameDTO
        return dto;
    }
}
