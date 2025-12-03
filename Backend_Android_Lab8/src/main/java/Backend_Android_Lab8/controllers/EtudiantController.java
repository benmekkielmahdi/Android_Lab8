package Backend_Android_Lab8.controllers;

import Backend_Android_Lab8.entities.Etudiant;
import Backend_Android_Lab8.services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin("*")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant e) {
        return service.create(e);
    }

    @GetMapping
    public List<Etudiant> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Etudiant update(@PathVariable long id, @RequestBody Etudiant e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
