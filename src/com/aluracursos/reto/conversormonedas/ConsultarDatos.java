package com.aluracursos.reto.conversormonedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDatos {
//    String url = "https://v6.exchangerate-api.com/v6/142521fe8b2e724ada81a326/pair/MXN/USD/125";


    public Monedas buscarMonedas(String base){
        String url = "https://v6.exchangerate-api.com/v6/142521fe8b2e724ada81a326/latest/"+base;
        URI direccion = URI.create(url);
        {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().
                        uri(direccion).
                        build();
                HttpResponse<String> response = client.send(request, HttpResponse
                        .BodyHandlers
                        .ofString());
                //System.out.println(response.body());
                return new Gson().fromJson(response.body(), Monedas.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
