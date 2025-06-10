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
    private String fpgPermiteParcelamento;

    @Column(name = "FPG_NUMERO_MAX_PARCELA")
    private Integer fpgNumeroMaxParcela;

    @Column(name = "FPG_TAXA_ADICIONAL")
    private Integer fpgTaxaAdicional;

    @Column(name = "FPG_STATUS")
    private Boolean fpgStatus;

    public FormaPagamento() {

    }

    public FormaPagamento(Long fpgId, String fpgDescricao, String fpgPermiteParcelamento, Integer fpgNumeroMaxParcela, Integer fpgTaxaAdicional, Boolean fpgStatus) {
        this.fpgId = fpgId;
        this.fpgDescricao = fpgDescricao;
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
        this.fpgNumeroMaxParcela = fpgNumeroMaxParcela;
        this.fpgTaxaAdicional = fpgTaxaAdicional;
        this.fpgStatus = fpgStatus;
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

    public String getFpgPermiteParcelamento() {
        return fpgPermiteParcelamento;
    }

    public void setFpgPermiteParcelamento(String fpgPermiteParcelamento) {
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
    }

    public Integer getFpgNumeroMaxParcela() {
        return fpgNumeroMaxParcela;
    }

    public void setFpgNumeroMaxParcela(Integer fpgNumeroMaxParcela) {
        this.fpgNumeroMaxParcela = fpgNumeroMaxParcela;
    }

    public Integer getFpgTaxaAdicional() {
        return fpgTaxaAdicional;
    }

    public void setFpgTaxaAdicional(Integer fpgTaxaAdicional) {
        this.fpgTaxaAdicional = fpgTaxaAdicional;
    }

    public Boolean getFpgStatus() {
        return fpgStatus;
    }

    public void setFpgStatus(Boolean fpgStatus) {
        this.fpgStatus = fpgStatus;
    }
}
