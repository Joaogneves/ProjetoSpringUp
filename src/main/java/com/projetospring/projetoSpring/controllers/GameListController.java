package com.projetospring.projetoSpring.controllers;

import com.projetospring.projetoSpring.dto.GameDTO;
import com.projetospring.projetoSpring.dto.GameListDTO;
import com.projetospring.projetoSpring.dto.GameMinDTO;
import com.projetospring.projetoSpring.services.GameListService;
import com.projetospring.projetoSpring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;
    @Autowired
    private  GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        var list = service.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> list = gameService.findByList(listId);
        return list;
    }

}
