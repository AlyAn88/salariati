package com.example.salariati.electra;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class Metode {
    static String addAngajat (String nume, String prenume, int salariu, String numeFunctie, String nivel) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        PreparedStatement updateempAngajat = con.prepareStatement("insert into angajat values (?,?,?,?)");
        PreparedStatement updateempFunctie = con.prepareStatement("insert into functie values (?,?,?)");
        updateempAngajat.setInt(1, 0);
        updateempAngajat.setString(2, nume);
        updateempAngajat.setString(3, prenume);
        updateempAngajat.setInt(4, salariu);
        updateempFunctie.setInt(1, 0);
        updateempFunctie.setString(2, numeFunctie);
        updateempFunctie.setString(3, nivel);
        Statement all = con.createStatement();
        String angajati = "select * from angajat where nume = "+"'" +nume+"'";
        ResultSet rs = all.executeQuery(angajati);
        String is = "true";
        while (rs.next()) {
            if (rs.getString("nume").equals(nume) && rs.getString("prenume").equals(prenume)) {
                System.out.println(nume + " " + prenume + " este deja inregistrat");
                is = "false";
            }
        }
        if (is.equals("true")) {
            updateempAngajat.executeUpdate();
            updateempFunctie.executeUpdate();
        }
        return is;
    }
    static Set<String> startWorking () throws SQLException {
        Set<String> angajati = new TreeSet<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all =con.createStatement();
        String lista="select * from angajat";
        ResultSet rs= all.executeQuery(lista);
        while (rs.next()){
          String angajat=rs.getString("nume")+" "+ rs.getString("prenume") + " is working";
            angajati.add(angajat);
        }
        return angajati;
    }
}
