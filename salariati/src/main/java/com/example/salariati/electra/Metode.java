package com.example.salariati.electra;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class Metode {
    static String addAngajat(String nume, String prenume, int salariu, String numeFunctie, String nivel) throws SQLException {
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
        String angajati = "select * from angajat where nume = " + "'" + nume + "'";
        ResultSet rs = all.executeQuery(angajati);
        while (rs.next()) {
            if (rs.getString("prenume").equals(prenume)) {
                return nume + " " + prenume + " este deja inregistrat";
            }
        }
        updateempAngajat.executeUpdate();
        updateempFunctie.executeUpdate();
        return nume + " " + prenume + " este inregistrat";
    }

    static Set<String> startWorking() throws SQLException {
        Set<String> angajati = new TreeSet<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all = con.createStatement();
        String lista = "select * from angajat";
        ResultSet rs = all.executeQuery(lista);
        while (rs.next()) {
            String angajat = rs.getString("nume") + " " + rs.getString("prenume") + " is working";
            angajati.add(angajat.toUpperCase());
        }
        return angajati;
    }

    static Set<String> allPersons() throws SQLException {
        Set<String> angajati = new TreeSet<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all = con.createStatement();
        String listaAngajat = "SELECT * FROM angajat INNER JOIN functie ON angajat.id = functie.id";
        ResultSet rs = all.executeQuery(listaAngajat);
        while (rs.next()) {
            String angajat = rs.getString("nume") + " " + rs.getString("prenume") + " " + rs.getInt("salariu") + " " + rs.getString("numeFunctie") + " " + rs.getString("nivel");
            angajati.add(angajat.toUpperCase());
        }
        return angajati;
    }

    static int selectPerson(String nume, String prenume) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all = con.createStatement();
        String select = "SELECT * FROM angajat INNER JOIN functie ON angajat.id = functie.id where nume =" + "'" + nume + "'";
        ResultSet rs = all.executeQuery(select);
        while (rs.next()) {
            if (rs.getString("prenume").equals(prenume)) {
                return rs.getInt("id");
            }
        }
        return 0;

    }

    static void change(int id, int salariuModificat) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all = con.createStatement();
        String select = "update angajat set salariu =" + salariuModificat + "where id=" + id;
        ;
        ResultSet rs = all.executeQuery(select);
    }

}
