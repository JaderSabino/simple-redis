package com.sabino.simpleredis.dto;

import java.io.Serializable;

public class PokemonDTO {

    private Integer id;
    private String nome;
    private String tipo;

    public PokemonDTO(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
