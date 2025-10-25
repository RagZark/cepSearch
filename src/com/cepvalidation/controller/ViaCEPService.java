package com.cepvalidation.controller;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ViaCEPService {
    private String cep;
    private HttpRequest request;
    private HttpClient httpClient;
    private HttpResponse<String> postResponse;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest() {
        String url = "https://viacep.com.br/ws/" + getCep() + "/json";
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> getResponse() {
        return postResponse;
    }

    public void setGetResponse(HttpResponse<String> postResponse) {
        this.postResponse = postResponse;
    }
}
