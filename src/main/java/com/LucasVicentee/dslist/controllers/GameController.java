package com.LucasVicentee.dslist.controllers;

import com.LucasVicentee.dslist.dto.GameDTO;
import com.LucasVicentee.dslist.dto.GameMinDTO;
import com.LucasVicentee.dslist.entities.Game;
import com.LucasVicentee.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define esta classe como um controlador
@RequestMapping(value = "/games") //Mapeando os recursos Games
public class GameController {

    @Autowired //Injetando service no controller
    private GameService gameService;

    @GetMapping //Mapeando como Get por ser uma consulta no SQL
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}") //Adicionando o próximo caminho para encontrar o ID pela consulta do SQL
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result  = gameService.findByID(id);
        return result;
    }
}
