
package com.example.salariati.electra;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Set;
@CrossOrigin(origins = "*")
@RestController
public class Controler {

    @PostMapping("/addAngajat")
    String addAngajat(@RequestBody Person p) throws SQLException {
        return Metode.addAngajat(p.getNume(), p.getPrenume(), p.getSalariu(), p.getFunctie());
    }


    @GetMapping("/startWork")
    Set<String> startWork() throws SQLException {
        return Metode.startWorking();
    }

    @GetMapping("/allAngajati")
    Set<Person> allAngajati() throws SQLException {
        return Metode.allPersons();
    }

    @GetMapping("/selectAngajat")
    int selectAngajat(@RequestParam String nume, @RequestParam String prenume) throws SQLException {
        return Metode.selectPerson(nume, prenume);
    }

    @PutMapping("/changeSalariu")
    String change(@RequestBody int id,  @RequestParam int salariuModificat) throws SQLException {
        if (id != 0) {
            Metode.change(id, salariuModificat);
            return "A fost modificatr cu succes";
        }
        return "Persoana nu este in baza de date";
    }
}
