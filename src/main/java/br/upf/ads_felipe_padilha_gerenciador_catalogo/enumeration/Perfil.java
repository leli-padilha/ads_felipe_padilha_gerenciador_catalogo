/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ads_felipe_padilha_gerenciador_catalogo.enumeration;

/**
 *
 * @author User
 */
public enum Perfil {
    ADMIN("Administrador"),   // gerencia usuários e catálogo
    EDITOR("Editor");         // gerencia só o catálogo de pranchas

    private final String descricao;

    Perfil(String descricao) { this.descricao = descricao; }

    public String getDescricao() { return descricao; }
}
