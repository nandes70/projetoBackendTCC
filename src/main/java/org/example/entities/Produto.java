package org.example.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @NotBlank(message = "Nome do Produto é Obrigatório")
    @Column(name = "PRO_NOME")
    private String proNome;
    @NotBlank(message = "Descrição do Produto é Obrigatória")
    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @NotBlank(message = "Estoque do Produto é Obrigatório")
    @Column(name = "PRO_ESTOQUE")
    private Integer proEstoque;

    @NotBlank(message = "Categoria do Produto é Obrigatório")
    @Size(max = 50, message = "Categoria deve ter no máximo 50 caracteres")
    @Column(name = "PRO_CATEGORIA", length = 50)
    private String proCategoria;

    @NotBlank(message = "Codigo de Barra do Produto é Obrigatório")
    @Column(name = "PRO_CODIGOBARRA")
    private String proCodigoBarra;

    @NotBlank(message = "Marca do Produto é Obrigatório")
    @Size(max = 50, message = "Marca deve ter no máximo 50 caracteres")
    @Column(name = "PRO_MARCA", length = 50)
    private String proMarca;

    @NotBlank(message = "Status do Produto é Obrigatório")
    @Column(name = "PRO_STATUS")
    private Boolean proStatus;

    @NotBlank(message = "Preço Custo do Produto é Obrigatório")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @NotBlank(message = "Preço de Venda do Produto é Obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço de Venda deve ser maior que zero")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double proPrecoVenda;

    @NotBlank(message = "Fabricante do Produto é Obrigatório")
    @Column(name = "PRO_FABRICANTE")
    private String proFabricante;

    @NotBlank(message = "Data de cadastro do Produto é Obrigatório")
    @Column(name = "PRO_DATA_CADASTRO")
    private LocalDateTime proDataCadastro;

    @NotBlank(message = "Aplicação do Produto é Obrigatório")
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