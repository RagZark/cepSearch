package com.cepvalidation.model;

public class Cep {
    private String cep;
    private String localidade;
    private String uf;
    private String logradouro;

    public Cep(InfoCep infoCep){
        this.cep = infoCep.cep();
        this.logradouro = infoCep.logradouro();
        this.localidade = infoCep.localidade();
        this.uf = infoCep.uf();
    }

    @Override
    public String toString(){
        return "(Cep: " + cep + ", Localidade: " + localidade + ", UF: " + uf + ", Logadouro: " + logradouro + ")";
    }
}
