/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ads_felipe_padilha_gerenciador_catalogo.model;

/**
 *
 * @author User
 */
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    // gere getters e setters pela IDE (NetBeans: Alt+Insert > Getter and Setter)

    @Override
    public int hashCode() { return Objects.hashCode(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca)) return false;
        return Objects.equals(id, ((Marca) o).id);
    }

    @Override
    public String toString() { return nome; }
}
