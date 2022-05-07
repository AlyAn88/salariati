package com.example.salariati.electra;

public class Person {
    private String nume;
    private String prenume;
    private int salariu;
    private String numeFunctie;
    private String nivel;

    public void setAngajat(String nume, String prenume, int salariu, String numeFunctie, String nivel) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.numeFunctie = numeFunctie;
        this.nivel = nivel;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
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
