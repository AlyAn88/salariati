package test;

import java.time.LocalDate;

public class Person {
    private String name;
    private String pname;
    private LocalDate nastere;

    public Person() {

    }

    public Person (String name){
        this.name = name;
        System.out.println(this.name);
    }

    public Person (String name, String pname,LocalDate nastere){
        this(name);
        this.pname = pname;
        this.nastere=nastere;
        System.out.print(" ");
        System.out.print(this.pname);
        System.out.print(" ");
        System.out.print(this.nastere);
        System.out.println("");
    }
}
