package com.sabino.simpleredis.mappers;

import com.sabino.simpleredis.dto.PokemonDTO;
import com.sabino.simpleredis.entidades.PokemonEntity;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapper {
    public PokemonDTO pokemonEntityToPokemonDTO(PokemonEntity pokemonEntity) {
        return new PokemonDTO(pokemonEntity.getId(), pokemonEntity.getNome(), pokemonEntity.getTipo());
    }

    public PokemonEntity pokemonDtoToPokemonEntity(PokemonDTO pokemonDTO) {
        return new PokemonEntity(pokemonDTO.getId(), pokemonDTO.getNome(), pokemonDTO.getTipo());
    }
}
