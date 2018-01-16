package controleur;

public class Technicien 
{
	private int idTech;
	private String nom, prenom, comptetence;
	
	public Technicien()
	{
		this.idTech = 0;
		this.nom="";
		this.prenom="";
		this.comptetence="";
	}
	
	public Technicien(int idTech, String nom, String prenom, String competence)
	{
		this.idTech = idTech;
		this.nom=nom;
		this.prenom=prenom;
		this.comptetence= competence;
	}
	
	public Technicien(String nom, String prenom, String competence)
	{
		this.idTech = 0;
		this.nom=nom;
		this.prenom=prenom;
		this.comptetence= competence;
	}

	public int getIdTech() {
		return idTech;
	}

	public void setIdTech(int idTech) {
		this.idTech = idTech;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getComptetence() {
		return comptetence;
	}

	public void setComptetence(String comptetence) {
		this.comptetence = comptetence;
	}
	
	
}
