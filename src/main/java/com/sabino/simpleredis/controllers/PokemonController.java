package com.sabino.simpleredis.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @PostMapping()
    public String cadastrarPokemon() {
        return "Funciona";
    }

}
