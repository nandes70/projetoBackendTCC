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
    private String fpgNumeroMaxParcela;

    @Column(name = "FPG_TAXA_ADICIONAL")
    private String fpgTaxaAdicional;

    @Column(name = "FPG_STATUS")
    private String fpgStatus;

    public FormaPagamento() {

    }

    public FormaPagamento(Long fpgId, String fpgDescricao, String fpgPermiteParcelamento, String fpgNumeroMaxParcela, String fpgTaxaAdicional, String fpgStatus) {
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

    public String getFpgNumeroMaxParcela() {
        return fpgNumeroMaxParcela;
    }

    public void setFpgNumeroMaxParcela(String fpgNumeroMaxParcela) {
        this.fpgNumeroMaxParcela = fpgNumeroMaxParcela;
    }

    public String getFpgTaxaAdicional() {
        return fpgTaxaAdicional;
    }

    public void setFpgTaxaAdicional(String fpgTaxaAdicional) {
        this.fpgTaxaAdicional = fpgTaxaAdicional;
    }

    public String getFpgStatus() {
        return fpgStatus;
    }

    public void setFpgStatus(String fpgStatus) {
        this.fpgStatus = fpgStatus;
    }
}
