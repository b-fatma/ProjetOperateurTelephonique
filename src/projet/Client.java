package projet;

import java.time.Duration;
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
    protected Abonnement typeAbon;
    protected int delai_paiement;
    protected ArrayList<Appel> appels;
    protected ArrayList<SMS> SMS;
    protected ArrayList<LocalDate> datesRappels;


    public Client() 
    {
    	this.etat = Etat.ACTIF;
        appels = new ArrayList<>();
        SMS = new ArrayList<>();
        datesRappels= new ArrayList<>();
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
        appels = new ArrayList<>();
        SMS = new ArrayList<>();
        datesRappels= new ArrayList<>();
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


	public Abonnement getTypeAbon() {
		return typeAbon;
	}

	public void setTypeAbon(Abonnement typeAbon) {
		this.typeAbon = typeAbon;
	}

	public LocalDate getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(LocalDate dateContrat) {
		this.dateContrat = dateContrat;
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

	public ArrayList<Appel> getAppels() {
		return appels;
	}

	public void setAppels(ArrayList<Appel> appels) {
		this.appels = appels;
	}

	public ArrayList<SMS> getSMS() {
		return SMS;
	}

	public void setSMS(ArrayList<SMS> sMS) {
		SMS = sMS;
	}

	public ArrayList<LocalDate> getDatesRappels() {
		return datesRappels;
	}

	public void setDatesRappels(ArrayList<LocalDate> datesRappels) {
		this.datesRappels = datesRappels;
	}

	public void modifierAdresse()
    {
        adresse.modifier();
    }
	
	
	public void saisir()
	{
		Scanner scan = new Scanner(System.in);
		
		this.numTel = PointDeVente.saisirNum();
		
		System.out.print("Numero de contrat: ");
		this.numContrat = scan.nextLine();
		
		System.out.print("La date du contrat: ");
		this.dateContrat = Operateur.saisirDate();
		
		System.out.print("Nom: ");
		this.nom = scan.nextLine();
		
		System.out.print("Prenom: ");
		this.prenom = scan.nextLine();
		
		System.out.println("Adresse: ");
		this.adresse = new Adresse();
		this.adresse.saisir();
		
		System.out.print("Adresse Mail: ");
		this.adresseMail = scan.next();
	}
	
    
    public boolean egale(Client c)
    {
    	return (this.numTel.equals(c.getNumTel()));
    }
    
    
    
    @Override
	public String toString() {
		return "Numero de telephone: " + numTel + ", Numero de contrat: " + numContrat + ", Nom: " + nom + ", Prénom: " + prenom
				+ ", Adresse mail: " + adresseMail + ", Date de fin de contrat: " + dateContrat + ", Adresse: " + adresse + ", Etat: "
				+ etat + ", Abonnement: " + typeAbon + "]";
	}

	public void afficher()
	{
		System.out.println(this.toString());
	}
	
	public void afficherRappels()
	{
		int cmp = 1;
		for(LocalDate d : this.datesRappels)
		{
			System.out.println("Rappel N°" + cmp + ": " + d.toString()); 
			cmp++;
		}
	}
	
	public void afficherAppels()
	{
		long duree = 0;
		int cmp = 1;
		for(Appel a : this.appels)
		{
			System.out.print("Appel N°" + cmp + ": ");
			a.afficher();
			duree += a.getDuree().getSeconds();
			cmp++;
		}
		System.out.println("\nLa durée cumulée: " + Duration.ofSeconds(duree).toString());
	}
	
	public void afficherAppels(LocalDate d1, LocalDate d2)
	{
		long duree = 0;
		int cmp = 1;
		for(Appel a : this.appels)
		{
			if(a.appartient(d1, d2))
			{
				System.out.print("Appel N°" + cmp + ": ");
				a.afficher();
				duree += a.getDuree().getSeconds();
				cmp++;
			}
		}
		System.out.println("\nLa durée cumulée: " + Duration.ofSeconds(duree).toString());
	}
    
    
    
    

    /*public abstract void appeler();

    public abstract void recevoirAppel();*/

    public abstract boolean echeanceDePaiement();
    
    public abstract boolean instanceDePaiement();
    
    public abstract String Facture();
    
    public void relancer()
    {
    	this.datesRappels.add(LocalDate.now());
    }




}
