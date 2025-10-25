package com.cepvalidation.model;

import com.cepvalidation.controller.ViaCEPService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        ViaCEPService viaCEPService = new ViaCEPService();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        
        System.out.println("Set your CEP code:");
        read.nextInt();

        String cepCode = read.toString();

        viaCEPService.setCep(cepCode);

        viaCEPService.setRequest();

        viaCEPService.setHttpClient();

        viaCEPService.setGetResponse(viaCEPService.getHttpClient().send(viaCEPService.getRequest(), HttpResponse.BodyHandlers.ofString()));

        String json = viaCEPService.getResponse().body();

        InfoCep infoCep = gson.fromJson(json, InfoCep.class);

        Cep cep = new Cep(infoCep);

        System.out.println(cep);
    }
}