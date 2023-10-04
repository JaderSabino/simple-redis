package com.sabino.simpleredis.service;

import com.sabino.simpleredis.dto.PokemonDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class PokemonService {

    List<PokemonDTO> pokemons = new ArrayList<>();
    AtomicInteger atomicInteger = new AtomicInteger();
    @CacheEvict(value = {"pokemon", "listar-pokemons"}, allEntries = true)
    public PokemonDTO cadastrarPokemon(PokemonDTO pokemonDTO) {
        pokemonDTO.setId(atomicInteger.incrementAndGet());
        pokemons.add(pokemonDTO);
        return pokemonDTO;
    }

    @Cacheable("pokemon")
    public PokemonDTO getPokemon(Integer id) {
        try {
            Thread.sleep(1000);
            return pokemons.stream().filter(pokemonDTO -> pokemonDTO.getId().equals(id)).toList().get(0);
        } catch (Exception e) {
            Logger logger = Logger.getLogger("PokemonService.class");
            logger.info("Não foi encontrado pokemon");
            return null;
        }
    }

    @Cacheable("listar-pokemons")
    public List<PokemonDTO> listarPokemons() {
        return pokemons;
    }

}
