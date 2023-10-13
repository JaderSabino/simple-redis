package com.sabino.simpleredis.dto;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash
public class PokemonDTO implements Serializable {

    private Integer id;
    private String nome;
    private String tipo;

    public PokemonDTO() {}

    public PokemonDTO(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public PokemonDTO(Integer id, String nome, String tipo) {
        this(nome, tipo);
        this.id = id;
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
