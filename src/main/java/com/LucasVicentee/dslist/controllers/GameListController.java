package com.LucasVicentee.dslist.controllers;

import com.LucasVicentee.dslist.dto.GameListDTO;
import com.LucasVicentee.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define esta classe como um controlador
@RequestMapping(value = "/lists") //Mapeando os recursos Games
public class GameListController {

    @Autowired //Injetando service no controller
    private GameListService gameListService;

    @GetMapping //Mapeando como Get por ser uma consulta no SQL
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
