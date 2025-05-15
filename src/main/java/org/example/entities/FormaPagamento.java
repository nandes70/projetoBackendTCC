package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FormaPagamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_ID")
    private Long fpgId;

    @Column(name = "FPG_DESCRICAO")
    private String fpgDescricao;

    @Column(name = "FPG_PERMITE_PARCELAMENTO")
    private Boolean fpgPermiteParcelamento;

    @Column(name = "FPG_NUMERO_MAX_PARCELA")
    private Integer fpgNumeroMaxParcela;

    @Column(name = "FPG_TAXA_ADICIONAL")
    private Double fpgTaxaAdicional;

    @Column(length = 30, name = "FPG_STATUS", nullable = false)
    private String fpgStatus;

    public FormaPagamento(Long fpgId, String fpgDescricao, Boolean fpgPermiteParcelamento, Integer fpgNumeroMaxParcela, Double fpgTaxaAdicional, String fpgStatus) {
        this.fpgId = fpgId;
        this.fpgDescricao = fpgDescricao;
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
        this.fpgNumeroMaxParcela = fpgNumeroMaxParcela;
        this.fpgTaxaAdicional = fpgTaxaAdicional;
        this.fpgStatus = fpgStatus;
    }



    public Boolean getFpgPermiteParcelamento() {
        return fpgPermiteParcelamento;
    }

    public void setFpgPermiteParcelamento(Boolean fpgPermiteParcelamento) {
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
    }

    public Integer getFpgNumeroMaxParcela() {
        return fpgNumeroMaxParcela;
    }

    public void setFpgNumeroMaxParcela(Integer fpgNumeroMaxParcela) {
        this.fpgNumeroMaxParcela = fpgNumeroMaxParcela;
    }

    public Double getFpgTaxaAdicional() {
        return fpgTaxaAdicional;
    }

    public void setFpgTaxaAdicional(Double fpgTaxaAdicional) {
        this.fpgTaxaAdicional = fpgTaxaAdicional;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public String getFpgDescricao() {
        return fpgDescricao;
    }

    public void setFpgDescricao(String fpgDescricao) {
        this.fpgDescricao = fpgDescricao;
    }

    public String getFpgStatus() { return fpgStatus; }
    public void setFpgStatus(String fpgStatus) { this.fpgStatus = fpgStatus; }

}