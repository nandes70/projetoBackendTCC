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

    @OneToMany(mappedBy = "endFornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    @NotBlank(message = "Nome Fantasia obrigatório")
    @Size(max = 100, message = "Nome Fantasia deve ter no máximo 100 caracteres")
    @Column(name = "FOR_NOME_FANTASIA", nullable = false, length = 100)
    private String forNomeFantasia;

    @NotBlank(message = "Razão Social obrigatória")
    @Size(max = 100, message = "Razão Social deve ter no máximo 100 caracteres")
    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false, length = 100)
    private String forRazaoSocial;

    @NotBlank(message = "CNPJ obrigatório")
    @Size(max = 14, message = "CNPJ deve ter no máximo 14 caracteres")
    @CNPJ(message = "CNPJ inválido")
    @Column(name = "FOR_CNPJ", nullable = false, length = 14)
    private String forCnpj;

    @NotBlank(message = "Status obrigatório")
    @Size(max = 60, message = "Status deve ter no máximo 60 caracteres")
    @Column(name = "FOR_STATUS", nullable = false, length = 60)
    private String forStatus;

    public Fornecedor() {}

    public Fornecedor(Long forId, String forNomeFantasia, String forRazaoSocial, String forCnpj, String forStatus) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forRazaoSocial = forRazaoSocial;
        this.forCnpj = forCnpj;
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

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForStatus() {
        return forStatus;
    }

    public void setForStatus(String forStatus) {
        this.forStatus = forStatus;
    }

    // Métodos auxiliares para sincronização bidirecional
    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        endereco.setEndFornecedor(this);
    }

    public void removeEndereco(Endereco endereco) {
        enderecos.remove(endereco);
        endereco.setEndFornecedor(null);
    }

    public void addContato(Contato contato) {
        contatos.add(contato);
        contato.setConFornecedor(this);
    }

    public void removeContato(Contato contato) {
        contatos.remove(contato);
        contato.setConFornecedor(null);
    }
}
