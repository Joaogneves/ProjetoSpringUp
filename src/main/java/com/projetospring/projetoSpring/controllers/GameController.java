package com.projetospring.projetoSpring.controllers;

import com.projetospring.projetoSpring.dto.GameDTO;
import com.projetospring.projetoSpring.dto.GameMinDTO;
import com.projetospring.projetoSpring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        var list = service.findById(id);
        return list;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        var list = service.findAll();
        return list.stream().map(GameMinDTO::new).toList();
    }

}
