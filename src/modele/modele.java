package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Technicien;

public class modele
{
	public static String verifConnexion (String login, String mdp)
	{
		String requete = "SELECT count(*) as nb, droits from user "+
						 "WHERE LOGIN = '"+ login + "' and mdp = '"+ mdp + "';";
		String droits = "";
		Bdd uneBDD = new Bdd ("localhost", "intervention", "root", "root");
		try 
		{
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) 
			{
				droits = unRes.getString("droits");
				int nb = unRes.getInt("nb");
				if (nb==0) droits = "";
			}
			unRes.close();
			unStat.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur : "+exp);
		}
		return droits;
	}
	
	public static ArrayList<Client> selectAllClients()
	{
		ArrayList<Client> LesClients = new ArrayList<Client>();
		String requete = "SELECT * FROM client;";
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				LesClients.add(new Client(unRes.getInt("idclient"), unRes.getString("nom"), unRes.getString("prenom"), unRes.getString("adresse")));
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
			
		}
		catch(SQLException exp)
		{
			System.out.println(exp);
			
		}
		return LesClients;
		
	}
	
	public static void insertclient(Client unClient)
	{
		String requete = "insert into client values (null, '"+unClient.getNom() + "','"+unClient.getPrenom() + "','"
							+unClient.getAdresse()+"');";
		Bdd uneBdd = new Bdd ("localhost", "intervention", "root","root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println(exp);
		}
	}
	
	public static ArrayList<Technicien> selectAllTechniciens()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "Select * FROM technicien";
		Bdd uneBdd = new Bdd("localhost", "intervention", "root", "root");
		try
		{
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet UnRes = unStat.executeQuery(requete);
			while (UnRes.next())
			{
				int idTech = UnRes.getInt("idTech");
				String nom = UnRes.getString("nom");
				String prenom = UnRes.getString("prenom");
				String competence = UnRes.getString("competence");
				Technicien unTechnicien = new Technicien(idTech, nom, prenom, competence);
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			UnRes.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur "+exp);
		
		}
		return lesTechniciens;
	}
	
	public static Technicien SelectWhereTech(Technicien untechnicien) {
        String requete = "Select * from technicien where idtech = "+ untechnicien.getIdTech();
        Technicien untechresultat = null;
        Bdd uneBdd = new Bdd ("localhost","intervention","root","root");
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();;
            ResultSet unRes = unStat.executeQuery(requete);
            if(unRes.next()) {
                int idtech = unRes.getInt("idtech");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String competence = unRes.getString("competence");
                untechresultat = new Technicien(idtech,nom,prenom,competence);

            }
            unStat.close();
            unRes.close();
            uneBdd.seDeconnecter();

        }catch(SQLException exp) {
            System.out.println("Erreur de requete : "+requete);
        }
        return untechresultat;
    }
}