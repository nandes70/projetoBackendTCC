package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_CLI_ID")
    private Cliente conCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_FOR_ID")
    private Fornecedor conFornecedor;


    @Column(name = "CON_CELULAR", length = 14)
    private String conCelular;

    @Column(name = "CON_TELEFONE_COMERCIAL", length = 14)
    private String conTelefoneComercial;

    @Column(length = 55, name = "CON_EMAIL")
    private String conEmail;

    @Column(length = 55, name = "CON_EMAIL_SECUNDARIO")
    private String conEmailSecundario;



    public Contato() {
    }

    public Contato(Long conId, Cliente conCliente, String conCelular, String conTelefoneComercial, String conEmail, String conEmailSecundario) {
        this.conId = conId;
        this.conCliente = conCliente;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
        this.conEmailSecundario = conEmailSecundario;
    }

    public Contato(Long conId, Fornecedor conFornecedor, String conCelular, String conTelefoneComercial, String conEmail, String conEmailSecundario) {
        this.conId = conId;
        this.conFornecedor = conFornecedor;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
        this.conEmailSecundario = conEmailSecundario;
    }

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
    }

    public Fornecedor getConFornecedor() {
        return conFornecedor;
    }

    public void setConFornecedor(Fornecedor conFornecedor) {
        this.conFornecedor = conFornecedor;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public String getConEmailSecundario() {
        return conEmailSecundario;
    }

    public void setConEmailSecundario(String conEmailSecundario) {
        this.conEmailSecundario = conEmailSecundario;
    }
}
