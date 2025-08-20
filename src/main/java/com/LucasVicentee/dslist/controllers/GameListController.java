package com.LucasVicentee.dslist.controllers;

import com.LucasVicentee.dslist.dto.GameListDTO;
import com.LucasVicentee.dslist.dto.GameMinDTO;
import com.LucasVicentee.dslist.services.GameListService;
import com.LucasVicentee.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define esta classe como um controlador
@RequestMapping(value = "/lists") //Mapeando os recursos Games
public class GameListController {

    @Autowired //Injetando service no controller
    private GameListService gameListService;

    @Autowired //Injetando service no controller
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games") //Mapeando como Get por ser uma consulta no SQL
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
