package org.example.entities;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @OneToMany(mappedBy = "endFornecedor", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @Column(name = "FOR_NOME_FANTASIA", nullable = false, length = 100)
    private String forNomeFantasia;

    @Column(name = "FOR_NOME_RESPONSAVEL", nullable = false, length = 100)
    private String forNomeresponsavel;
    
    @Column(name = "FOR_CNPJ", nullable = false, length = 100)
    private String forCnpj;

    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false, unique = true, length = 100)
    private String forRazaoSocial;

    @Column(name = "FOR_STATUS", nullable = false, length = 60)
    private String forStatus;

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNomeFantasia, String forNomeresponsavel, String forCnpj, String forRazaoSocial, String forStatus) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forNomeresponsavel = forNomeresponsavel;
        this.forCnpj = forCnpj;
        this.forRazaoSocial = forRazaoSocial;
        this.forStatus = forStatus;
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
    }

    public String getForNomeresponsavel() {
        return forNomeresponsavel;
    }

    public void setForNomeresponsavel(String forNomeresponsavel) {
        this.forNomeresponsavel = forNomeresponsavel;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

    public String getForStatus() {
        return forStatus;
    }

    public void setForStatus(String forStatus) {
        this.forStatus = forStatus;
    }
}