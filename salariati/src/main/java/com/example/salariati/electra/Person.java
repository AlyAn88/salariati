package com.example.salariati.electra;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ADeserializer.class)
public abstract class Person implements Comparable<Person> {
    private String nume;
    private String prenume;
    private int salariu;
    private Functie functie;

    abstract String isWorking();

    public void setAngajat(String nume, String prenume, int salariu, Functie functie) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.functie = functie;
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

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    @Override
    public int compareTo(Person o) {
        int i = this.nume.compareTo(o.getNume());
        if (i == 0) {
            i = this.prenume.compareTo(o.getPrenume());
            return i;
        }

        return i;
    }
}


