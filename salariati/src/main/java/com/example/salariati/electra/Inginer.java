package com.example.salariati.electra;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class Inginer extends Person{
    @Override
    public String isWorking() {
        return "gandeste";
    }
}
