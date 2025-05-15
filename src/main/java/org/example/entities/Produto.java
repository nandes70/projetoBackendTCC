package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @Column(name = "PRO_NOME")
    private String proNome;

    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @Column(name = "PRO_ESTOQUE")
    private Integer proEstoque;

    @Column(name = "PRO_CATEGORIA")
    private String proCategoria;

    @Column(name = "PRO_CODIGOBARRA")
    private String proCodigoBarra;

    @Column(name = "PRO_MARCA")
    private String proMarca;

    @Column(name = "PRO_STATUS")
    private Boolean proStatus;

    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private Double proPrecoVenda;

    @Column(name = "PRO_FABRICANTE")
    private String proFabricante;

    @Column(name = "PRO_DATA_CADASTRO")
    private LocalDateTime proDataCadastro;

    @Column(name = "PRO_APLICACAO")
    private String proAplicacao;



    public Produto() {
    }

    public Produto(Long proId, String proNome, String proDescricao, Integer proEstoque, String proCategoria, String proCodigoBarra, String proMarca, Boolean proStatus, Double proPrecoCusto, Double proPrecoVenda, String proFabricante, LocalDateTime proDataCadastro, String proAplicacao) {
        this.proId = proId;
        this.proNome = proNome;
        this.proDescricao = proDescricao;
        this.proEstoque = proEstoque;
        this.proCategoria = proCategoria;
        this.proCodigoBarra = proCodigoBarra;
        this.proMarca = proMarca;
        this.proStatus = proStatus;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.proFabricante = proFabricante;
        this.proDataCadastro = proDataCadastro;
        this.proAplicacao = proAplicacao;
    }

    public LocalDateTime getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(LocalDateTime proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public Integer getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(Integer proEstoque) {
        this.proEstoque = proEstoque;
    }

    public String getProCodigoBarra() {
        return proCodigoBarra;
    }

    public void setProCodigoBarra(String proCodigoBarra) {
        this.proCodigoBarra = proCodigoBarra;
    }

    public Boolean getProStatus() {
        return proStatus;
    }

    public void setProStatus(Boolean proStatus) {
        this.proStatus = proStatus;
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