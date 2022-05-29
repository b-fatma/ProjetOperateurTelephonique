package projet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Client
{
    public enum Etat {ACTIF, BLOQUE}
    protected String numTel, numContrat, nom, prenom, adresseMail;
    protected LocalDate dateContrat;
    protected Adresse adresse;
    protected Etat etat;
    

    protected ArrayList<Appel> appelsEntrants;
    protected ArrayList<Appel> appelsSortants;
    protected ArrayList<SMS> SMSsortants;


    public Client() {
    }

    public Client(String numTel, String numContrat, String nom, String prenom,LocalDate dateContrat2, Adresse adresse, String adresseMail)
    {
        this.numTel = numTel;
        this.numContrat = numContrat;
        this.nom = nom;
        this.prenom = prenom;
        this.dateContrat = dateContrat2;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.etat = Etat.ACTIF;
        appelsEntrants = new ArrayList<>();
        appelsSortants = new ArrayList<>();
        SMSsortants  = new ArrayList<>();
    }
    
    


    public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
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

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	

	public LocalDate getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(LocalDate dateContrat) {
		this.dateContrat = dateContrat;
	}

	public ArrayList<SMS> getSMSsortants() {
		return SMSsortants;
	}

	public void setSMSsortants(ArrayList<SMS> sMSsortants) {
		SMSsortants = sMSsortants;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public ArrayList<Appel> getAppelsEntrants() {
		return appelsEntrants;
	}

	public void setAppelsEntrants(ArrayList<Appel> appelsEntrants) {
		this.appelsEntrants = appelsEntrants;
	}

	public ArrayList<Appel> getAppelsSortants() {
		return appelsSortants;
	}

	public void setAppelsSortants(ArrayList<Appel> appelsSortants) {
		this.appelsSortants = appelsSortants;
	}

	public void modifierAdresse()
    {
        adresse.modifier();
    }
	
	
	public void saisir()
	{
		Scanner scan = new Scanner(System.in);
		
		this.numTel = PointDeVente.saisirNum();
		
		System.out.println("Numero de contrat: ");
		this.numContrat = scan.next();
		
		System.out.println("La date du contrat: ");
		this.dateContrat = Operateur.saisirDate();
		
		System.out.println("Nom: ");
		this.nom = scan.nextLine();
		
		System.out.println("Prenom: ");
		this.nom = scan.nextLine();
		
		System.out.println("Adresse: ");
		this.adresse = Adresse.saisir();
		
		System.out.println("Adresse Mail: ");
		this.adresseMail = scan.next();		
	}
	
    
    public boolean egale(Client c)
    {
    	return (this.numTel.equals(c.getNumTel()));
    }
    
    
    

    /*public abstract void appeler();

    public abstract void recevoirAppel();

    public abstract boolean enEcheanceDePaiement();*/
    
    /*public abstract boolean enInstanceDePaiement();*/




}
