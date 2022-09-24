package com.example.salariati.electra;

public class Functie {
    private String numeFunctie;
    private String nivel;

    public void setFunctie (String numeFunctie, String nivel){
        this.numeFunctie=numeFunctie;
        this.nivel=nivel;
    }

    public String getNumeFunctie() {
        return numeFunctie;
    }

    public void setNumeFunctie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
