package com.example.salariati.electra;

import java.sql.*;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Metode {
    static String addAngajat(String nume, String prenume, int salariu, Functie functie) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        PreparedStatement updateempAngajat = con.prepareStatement("insert into angajat values (?,?,?,?)");
        PreparedStatement updateempFunctie = con.prepareStatement("insert into functie values (?,?,?)");
        updateempAngajat.setInt(1, 0);
        updateempAngajat.setString(2, nume);
        updateempAngajat.setString(3, prenume);
        updateempAngajat.setInt(4, salariu);
        updateempFunctie.setInt(1, 0);
        updateempFunctie.setString(2, functie.getNumeFunctie());
        updateempFunctie.setString(3, functie.getNivel());
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
        String lista = "SELECT * FROM angajat INNER JOIN functie ON angajat.id = functie.id";
        ResultSet rs = all.executeQuery(lista);

        while (rs.next()) {
            Person f;
            String numeFunctie = rs.getString("numeFunctie").toUpperCase(Locale.ROOT);
            ListaFunctii numeFunctieEnum = ListaFunctii.valueOf(numeFunctie);
            switch (numeFunctieEnum) {
                case INGINER:
                    f = new Inginer();
                    break;
                case ELECTRONIST:
                    f = new Electronist();
                    break;
                case OPERATOR:
                    f = new Operator();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + numeFunctieEnum);
            }
            String angajat = rs.getString("nume") + " " + rs.getString("prenume") + f.isWorking();
            angajati.add(angajat.toUpperCase());
        }
        return angajati;
    }

    static Set<Person> allPersons() throws SQLException {
        Set<Person> angajati = new TreeSet<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/angajati", "root", "3636");
        Statement all = con.createStatement();
        String listaAngajat = "SELECT * FROM angajat INNER JOIN functie ON angajat.id = functie.id";
        ResultSet rs = all.executeQuery(listaAngajat);
        while (rs.next()) {
            Functie functie= null;
            functie.setFunctie( rs.getString("numeFunctie"), rs.getString("nivel"));
            Person angajat = null;
            angajat.setAngajat(rs.getString("nume"), rs.getString("prenume"), rs.getInt("salariu"),functie);
            angajati.add(angajat);
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
        all.executeQuery(select);
    }

}
