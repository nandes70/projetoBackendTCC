package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @ManyToOne
    @JoinColumn(name = "FOR_ID")
    private Fornecedor idFornecedor;

    @NotBlank(message = "Nome do Produto é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "PRO_NOME", length = 100, nullable = false)
    private String proNome;

    @NotBlank(message = "Descrição do Produto é obrigatória")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    @Column(name = "PRO_DESCRICAO", length = 255, nullable = false)
    private String proDescricao;

    @NotNull(message = "Estoque do Produto é obrigatório")
    @Min(value = 0, message = "Estoque não pode ser negativo")
    @Column(name = "PRO_OBSERVACAO", nullable = false)
    private Integer proObservacao;

    @NotNull(message = "Estoque do Produto é obrigatório")
    @Min(value = 0, message = "Estoque não pode ser negativo")
    @Column(name = "PRO_GARANTIA", nullable = false)
    private Integer proGarantia;
    @NotNull(message = "Estoque do Produto é obrigatório")
    @Min(value = 0, message = "Estoque não pode ser negativo")
    @Column(name = "PRO_ESTOQUE", nullable = false)
    private Integer proEstoque;

    @NotBlank(message = "Categoria do Produto é obrigatória")
    @Size(max = 50, message = "Categoria deve ter no máximo 50 caracteres")
    @Column(name = "PRO_CATEGORIA", length = 50, nullable = false)
    private String proCategoria;

    @NotBlank(message = "Código de Barras do Produto é obrigatório")
    @Size(max = 50, message = "Código de Barras deve ter no máximo 50 caracteres")
    @Column(name = "PRO_CODIGOBARRA", length = 50, nullable = false)
    private String proCodigoBarra;

    @NotBlank(message = "Marca do Produto é obrigatória")
    @Size(max = 50, message = "Marca deve ter no máximo 50 caracteres")
    @Column(name = "PRO_MARCA", length = 50, nullable = false)
    private String proMarca;

    @NotNull(message = "Status do Produto é obrigatório")
    @Column(name = "PRO_STATUS", nullable = false)
    private Boolean proStatus;

    @NotNull(message = "Preço de Custo é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço de Custo deve ser maior que zero")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2, nullable = false)
    private Double proPrecoCusto;

    @NotNull(message = "Preço de Venda é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço de Venda deve ser maior que zero")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double proPrecoVenda;

    @NotBlank(message = "Fabricante do Produto é obrigatório")
    @Size(max = 100, message = "Fabricante deve ter no máximo 100 caracteres")
    @Column(name = "PRO_FABRICANTE", length = 100, nullable = false)
    private String proFabricante;

    @NotBlank(message = "Aplicação do Produto é obrigatória")
    @Size(max = 255, message = "Aplicação deve ter no máximo 255 caracteres")
    @Column(name = "PRO_APLICACAO", length = 255, nullable = false)
    private String proAplicacao;

    @Column(name = "PRO_DATA_CADASTRO", updatable = false)
    private LocalDateTime proDataCadastro;

    @Column(name = "PRO_DATA_ATUALIZACAO")
    private LocalDateTime proDataAtualizacao;

    public Produto() {}

    public Produto(Long proId, Fornecedor idFornecedor, String proNome, String proDescricao, Integer proEstoque, String proCategoria, String proCodigoBarra, String proMarca, Boolean proStatus, Double proPrecoCusto, Double proPrecoVenda, String proFabricante, String proAplicacao, LocalDateTime proDataCadastro, LocalDateTime proDataAtualizacao) {
        this.proId = proId;
        this.idFornecedor = idFornecedor;
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
        this.proAplicacao = proAplicacao;
        this.proDataCadastro = proDataCadastro;
        this.proDataAtualizacao = proDataAtualizacao;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public Integer getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(Integer proEstoque) {
        this.proEstoque = proEstoque;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoBarra() {
        return proCodigoBarra;
    }

    public void setProCodigoBarra(String proCodigoBarra) {
        this.proCodigoBarra = proCodigoBarra;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public Boolean getProStatus() {
        return proStatus;
    }

    public void setProStatus(Boolean proStatus) {
        this.proStatus = proStatus;
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

    public String getProFabricante() {
        return proFabricante;
    }

    public void setProFabricante(String proFabricante) {
        this.proFabricante = proFabricante;
    }

    public String getProAplicacao() {
        return proAplicacao;
    }

    public void setProAplicacao(String proAplicacao) {
        this.proAplicacao = proAplicacao;
    }

    public LocalDateTime getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(LocalDateTime proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public LocalDateTime getProDataAtualizacao() {
        return proDataAtualizacao;
    }

    public void setProDataAtualizacao(LocalDateTime proDataAtualizacao) {
        this.proDataAtualizacao = proDataAtualizacao;
    }
}
