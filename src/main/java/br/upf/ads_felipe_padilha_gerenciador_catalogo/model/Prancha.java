package br.upf.ads_felipe_padilha_gerenciador_catalogo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "prancha")
public class Prancha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "imagem")
    private String imagem;   // guardará só o NOME do arquivo (etapa de upload)

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca", referencedColumnName = "id")
    private Marca marca;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_construcao", referencedColumnName = "id")
    private Construcao construcao;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_quilha", referencedColumnName = "id")
    private Quilha quilha;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pintura", referencedColumnName = "id")
    private Pintura pintura;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Construcao getConstrucao() {
        return construcao;
    }

    public void setConstrucao(Construcao construcao) {
        this.construcao = construcao;
    }

    public Quilha getQuilha() {
        return quilha;
    }

    public void setQuilha(Quilha quilha) {
        this.quilha = quilha;
    }

    public Pintura getPintura() {
        return pintura;
    }

    public void setPintura(Pintura pintura) {
        this.pintura = pintura;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prancha)) {
            return false;
        }
        return Objects.equals(id, ((Prancha) o).id);
    }

    @Override
    public String toString() {
        return nome;
    }
}
