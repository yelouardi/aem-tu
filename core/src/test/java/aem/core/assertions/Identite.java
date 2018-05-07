package aem.core.assertions;

public class Identite {
    private String sexe;
    private String nom;
    private String prenom;

    public Identite(String sexe, String nom, String prenom) {
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
