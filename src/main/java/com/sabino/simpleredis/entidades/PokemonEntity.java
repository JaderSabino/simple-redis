package com.sabino.simpleredis.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class PokemonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String tipo;

    public PokemonEntity() {}

    public PokemonEntity(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public PokemonEntity(Integer id, String nome, String tipo) {
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
