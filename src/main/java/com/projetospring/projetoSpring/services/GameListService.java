package com.projetospring.projetoSpring.services;

import com.projetospring.projetoSpring.dto.GameDTO;
import com.projetospring.projetoSpring.dto.GameListDTO;
import com.projetospring.projetoSpring.entities.Game;
import com.projetospring.projetoSpring.repositories.GameListRepository;
import com.projetospring.projetoSpring.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository rep;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        var res = rep.findAll();
        return res.stream().map(GameListDTO::new).toList();
    }
}