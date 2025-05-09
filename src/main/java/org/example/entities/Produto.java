package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @Column(name = "PRO_NOME")
    private String proNome;

    @Column(name = "PRO_MARCA")
    private String proMarca;

    @Column(name = "PRO_CATEGORIA")
    private String proCategoria;

    @Column(name = "PRO_FABRICANTE")
    private String proFabricante;

    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @Column(name = "PRO_APLICACAO")
    private String proAplicacao;

    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private Double proPrecoVenda;

    public Produto() {
    }

    public Produto(Long proId, String proNome, String proMarca, String proCategoria, String proFabricante, String proDescricao, String proAplicacao, Double proPrecoCusto, Double proPrecoVenda) {
        this.proId = proId;
        this.proNome = proNome;
        this.proMarca = proMarca;
        this.proCategoria = proCategoria;
        this.proFabricante = proFabricante;
        this.proDescricao = proDescricao;
        this.proAplicacao = proAplicacao;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(Double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public Double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(Double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProFabricante() {
        return proFabricante;
    }

    public void setProFabricante(String proFabricante) {
        this.proFabricante = proFabricante;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public String getProAplicacao() {
        return proAplicacao;
    }

    public void setProAplicacao(String proAplicacao) {
        this.proAplicacao = proAplicacao;
    }
}