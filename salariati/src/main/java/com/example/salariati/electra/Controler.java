
package com.example.salariati.electra;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Set;

@RestController
public class Controler {

    @PostMapping("/addAngajat")
    String addAngajat(@RequestParam String nume, @RequestParam String prenume, @RequestParam int salar, @RequestParam String functie, @RequestParam String nivel) throws SQLException {
        return Metode.addAngajat(nume, prenume, salar, functie, nivel);
    }


    @GetMapping("/startWork")
    Set<String> startWork() throws SQLException {
        return Metode.startWorking();
    }

    @GetMapping("/allAngajati")
    Set<String> allAngajati() throws SQLException {
        return Metode.allPersons();
    }

    @GetMapping("/selectAngajat")
    int selectAngajat(@RequestParam String nume, @RequestParam String prenume) throws SQLException {
        return Metode.selectPerson(nume, prenume);
    }

    @PostMapping("/changeSlariu")
    String change(@RequestBody int id, int salariuModificat) throws SQLException {
        if (id != 0) {
            Metode.change(id, salariuModificat);
            return "A fost modificatr cu succes";
        }
        return "Persoana nu este in baza de date";
    }
}
