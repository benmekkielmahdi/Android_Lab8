package Backend_Android_Lab8.services;

import Backend_Android_Lab8.entities.Etudiant;
import Backend_Android_Lab8.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantRepository repo;

    public EtudiantService(EtudiantRepository repo) {
        this.repo = repo;
    }

    public Etudiant create(Etudiant e) {
        return repo.save(e);
    }

    public List<Etudiant> findAll() {
        return repo.findAll();
    }

    public Etudiant findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public Etudiant update(long id, Etudiant e) {
        Etudiant existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setNom(e.getNom());
        existing.setPrenom(e.getPrenom());
        existing.setVille(e.getVille());
        existing.setSexe(e.getSexe());

        return repo.save(existing);
    }
}
