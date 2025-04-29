package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @Column(name = "FOR_NOME_FANTASIA")
    private String forNomeFantasia;

    @Column(name = "FOR_CNPJ", unique = true, length = 14)
    private String forCnpj;

    @Column(name = "FOR_RAZAO_SOCIAL")
    private String forRazaoSocial;

    @Column(length = 30, name = "FOR_STATUS", nullable = false)
    private String forStatus;

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNome, String forNomeFantasia, String forCnpj, String forRazaoSocial, String forStatus) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
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

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
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