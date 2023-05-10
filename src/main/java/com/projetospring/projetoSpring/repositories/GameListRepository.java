package com.projetospring.projetoSpring.repositories;

import com.projetospring.projetoSpring.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
