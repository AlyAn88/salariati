
package com.example.salariati.electra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Set;

@RestController
public class Controler {

    @PostMapping("/addAngajat")
    String addAngajat (@RequestParam String nume, @RequestParam String prenume, @RequestParam int salar , @RequestParam String functie , @RequestParam String nivel ) throws SQLException {
        if (Metode.addAngajat(nume, prenume, salar, functie, nivel).equals("false")) {
            return nume + " " + prenume + " este deja inregistrat";
        }
        return nume + " " + prenume + " este inregistrat";

    }
    @GetMapping("/startWork")
    Set<String> startWork() throws SQLException {
        return Metode.startWorking();
    }

}
