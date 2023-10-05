package com.sabino.simpleredis.repositorios;

import com.sabino.simpleredis.entidades.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {
}
