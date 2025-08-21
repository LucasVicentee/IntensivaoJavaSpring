package com.LucasVicentee.dslist.services;

import com.LucasVicentee.dslist.dto.GameListDTO;
import com.LucasVicentee.dslist.entities.GameList;
import com.LucasVicentee.dslist.projections.GameMinProjection;
import com.LucasVicentee.dslist.repositories.GameListRepository;
import com.LucasVicentee.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired //Injeta a chamada de outra classe que está em outro pacote, assim cirando a ligação entre elas
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //Assegura que não vai bloquear o banco para escrita, assim ficando mais rápido
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList(); //Transformando uma lista que era de Game para uma lista de GameListDTO (Ou seja, apenas aquilo que eu preciso)
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) { //Função de modificar a localização do Game dentro da tabela
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
