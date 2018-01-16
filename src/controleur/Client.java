package controleur;

public class Client {
	
	private int idclient;
	private static int nbChampClients = 4;
	private String nom, prenom, adresse;
	
	public Client()
	{
		this.idclient= 0;
		this.nom=this.prenom=this.adresse="";
	}
	
	public Client(int idclient, String nom, String prenom, String adresse)
	{
		this.idclient= idclient;
		this.nom= nom;
		this.prenom= prenom;
		this.adresse=adresse;
	}
	
	public Client(String nom, String prenom, String adresse)
	{
		this.idclient= 0;
		this.nom= nom;
		this.prenom= prenom;
		this.adresse=adresse;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
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

	public static int getNbChampClients() {
		return nbChampClients;
	}

	public static void setNbChampClients(int nbChampClients) {
		Client.nbChampClients = nbChampClients;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
