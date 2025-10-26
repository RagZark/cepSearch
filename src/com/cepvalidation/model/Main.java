package com.cepvalidation.model;

import com.cepvalidation.controller.ViaCEPService;
import com.cepvalidation.exception.ConversionErrorException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.CharConversionException;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        ViaCEPService viaCEPService = new ViaCEPService();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        List<Cep> listCEP = new ArrayList<>();

        while (true){
            System.out.println("Set your CEP code:");
            String cepCode = read.nextLine();
            String formatedCepCode = cepCode.replaceAll("[^0-9]", "");

            if (formatedCepCode.equals("exit")){
                System.out.println("Exiting...");
                break;
            }

            if (formatedCepCode.contains("*.[a-zA-Z].*") || formatedCepCode.length() != 8){
                System.out.println("Please, set a valid CEP code with 8 numbers.");
                continue;
            }


            try {
                viaCEPService.setCep(formatedCepCode);

                viaCEPService.setRequest();

                viaCEPService.setHttpClient();

                viaCEPService.setGetResponse(viaCEPService.getHttpClient().send(viaCEPService.getRequest(), HttpResponse.BodyHandlers.ofString()));

                String json = viaCEPService.getResponse().body();

                InfoCep infoCep = gson.fromJson(json, InfoCep.class);

                Cep cep = new Cep(infoCep);

                System.out.println(cep);

            } catch (ConversionErrorException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}