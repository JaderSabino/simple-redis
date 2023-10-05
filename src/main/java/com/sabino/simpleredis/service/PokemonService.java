package com.sabino.simpleredis.service;

import com.sabino.simpleredis.dto.PokemonDTO;
import com.sabino.simpleredis.entidades.PokemonEntity;
import com.sabino.simpleredis.mappers.PokemonMapper;
import com.sabino.simpleredis.repositorios.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonMapper pokemonMapper;
    @CacheEvict(value = {"pokemon", "listar-pokemons"}, allEntries = true)
    public PokemonDTO cadastrarPokemon(PokemonDTO pokemonDTO) {
        PokemonEntity pokemonEntity = pokemonRepository.save(pokemonMapper.pokemonDtoToPokemonEntity(pokemonDTO));
        return pokemonMapper.pokemonEntityToPokemonDTO(pokemonEntity);
    }

    @Cacheable("pokemon")
    public PokemonDTO getPokemon(Integer id) {
        try {
            Thread.sleep(1000);
            return pokemonMapper.pokemonEntityToPokemonDTO(pokemonRepository.findById(id).orElseThrow());
        } catch (Exception e) {
            Logger logger = Logger.getLogger("PokemonService.class");
            logger.info("Não foi encontrado pokemon");
            return null;
        }
    }

    @Cacheable("listar-pokemons")
    public List<PokemonDTO> listarPokemons() {
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();
        return pokemonEntities.stream().map(pokemon -> pokemonMapper.pokemonEntityToPokemonDTO(pokemon)).collect(Collectors.toList());
    }

}
