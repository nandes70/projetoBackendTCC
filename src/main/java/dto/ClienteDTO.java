package dto;


import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class ClienteDTO {


    private Long cliId;
    private String cliNome;
    @CPF(message = "CPF inválido")
    private String cliCpf;
    private String cliStatus;


//endereco
    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;
    private String endBairro;


//contato
    private Long conId;
    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;
    private String conEmailSecundario;

    public ClienteDTO() {
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
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

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
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
