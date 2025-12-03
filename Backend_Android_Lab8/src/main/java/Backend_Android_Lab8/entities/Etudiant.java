package Backend_Android_Lab8.entities;


import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String ville;
    private String sexe;

    public Etudiant() {}

    public Etudiant(String nom, String prenom, String ville, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.sexe = sexe;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getVille() { return ville; }
    public String getSexe() { return sexe; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setVille(String ville) { this.ville = ville; }
    public void setSexe(String sexe) { this.sexe = sexe; }
}
