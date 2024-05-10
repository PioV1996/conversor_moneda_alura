package com.aluracursos.reto.conversormonedas;

import com.google.gson.JsonObject;


public record Monedas(
        String base_code
        , JsonObject conversion_rates) {

}
