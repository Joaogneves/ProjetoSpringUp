package com.projetospring.projetoSpring.services;

import com.projetospring.projetoSpring.dto.GameDTO;
import com.projetospring.projetoSpring.dto.GameMinDTO;
import com.projetospring.projetoSpring.entities.Game;
import com.projetospring.projetoSpring.projections.GameMinProjection;
import com.projetospring.projetoSpring.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository rep;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game res = rep.findById(id).get();
        return new GameDTO(res);
    }

    @Transactional(readOnly = true)
    public List<Game> findAll() {
        var res = rep.findAll();
        return res;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listid) {
        List<GameMinProjection> res = rep.searchByList(listid);
        return res.stream().map(GameMinDTO::new).toList();
    }

}