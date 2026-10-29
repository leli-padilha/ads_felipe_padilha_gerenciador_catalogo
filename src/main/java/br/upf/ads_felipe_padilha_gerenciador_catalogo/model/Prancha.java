package br.upf.ads_felipe_padilha_gerenciador_catalogo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Prancha implements Serializable {

    private Long id;
    private String nome;
    private String marca;
    private String tipo;
    private String estilo;
    private String tamanho;
    private double volume;
    private String quilha;
    private String nivel;
    private BigDecimal preco;
    private String descricao;

    public Prancha(Long id, String nome, String marca, String tipo, String estilo,
                   String tamanho, double volume, String quilha, String nivel,
                   BigDecimal preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.estilo = estilo;
        this.tamanho = tamanho;
        this.volume = volume;
        this.quilha = quilha;
        this.nivel = nivel;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getVolume() {
        return volume;
    }

    public String getQuilha() {
        return quilha;
    }

    public String getNivel() {
        return nivel;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
