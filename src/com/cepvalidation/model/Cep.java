package com.cepvalidation.model;

import com.cepvalidation.exception.ConversionErrorException;

public class Cep {
    private String cep;
    private String localidade;
    private String uf;
    private String logradouro;

    public Cep(InfoCep infoCep){

        if (infoCep.cep() == null || "null".equals(infoCep.cep())){
            throw new ConversionErrorException("Invalid CEP value, please type a valid CEP.");
        }

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
