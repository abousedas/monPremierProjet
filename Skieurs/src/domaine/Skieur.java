package domaine;

public class Skieur {
    private int no;
    private String nom;
    private String prenom;
    private Pays pays;
    
    public Skieur(int no, String nom, String prenom, Pays pays) { this.no=no; this.nom=nom; this.prenom=prenom; this.pays=pays; }
    
    public int getNo() { return no; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Pays getPays() { return pays; }
    
    public boolean equals(Object obj) { return this.no == ((Skieur)obj).no; }
    public String toString() { return prenom+" "+nom; }
}