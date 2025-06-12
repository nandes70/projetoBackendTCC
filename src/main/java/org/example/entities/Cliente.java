package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();
    @NotBlank(message = "Nome Obrigatório")
    @Size(max = 100, message = "Nome deve ter no maximo 100 caracteres")
    @Column(name = "CLI_NOME")
    private String cliNome;
    @NotBlank(message = "Cpf Obrigatório")
    @Size(max = 11, message = "Nome deve ter no maximo 100 caracteres")
    @Column(name = "CLI_CPF", length = 11)
    private String cliCpf;
    @NotBlank(message = "Status Obrigatório")
    @Size(max = 100, message = "Status deve ter no maximo 100 caracteres")
    @Column(length = 100, name = "CLI_STATUS", nullable = false)
    private String cliStatus;

    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, String cliStatus) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliStatus = cliStatus;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
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

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliStatus() {
        return cliStatus;
    }

    public void setCliStatus(String cliStatus) {
        this.cliStatus = cliStatus;
    }
}