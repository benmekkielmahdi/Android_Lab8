package Backend_Android_Lab8.repositories;


import Backend_Android_Lab8.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
