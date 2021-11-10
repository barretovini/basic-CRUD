package com.games.vini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.vini.entities.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long> {

}
