package com.sabino.simpleredis.controllers;

import com.sabino.simpleredis.dto.PokemonDTO;
import com.sabino.simpleredis.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<PokemonDTO> cadastrarPokemon(@RequestBody PokemonDTO pokemonDto) {
        PokemonDTO pokemonDTOReturn = pokemonService.cadastrarPokemon(pokemonDto);
        return ResponseEntity.ok(pokemonDTOReturn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable Integer id) {
        PokemonDTO pokemonDTO = pokemonService.getPokemon(id);
        return ResponseEntity.ok(pokemonDTO);
    }

    @GetMapping("listar")
    public ResponseEntity<List<PokemonDTO>> listarPokemons() {
        List<PokemonDTO> pokemonsDTO = pokemonService.listarPokemons();
        return ResponseEntity.ok(pokemonsDTO);
    }

}
