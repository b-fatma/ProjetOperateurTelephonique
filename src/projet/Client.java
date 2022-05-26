package projet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Client
{
    public enum Etat {ACTIF, BLOQUE}
    protected String numTel, numContrat, nom, prenom, adresseMail;
    protected Date dateContrat;
    protected Adresse adresse;
    protected Etat etat;

    protected ArrayList<Appel> appelsEntrants;
    protected ArrayList<Appel> appelsSortants;
    protected ArrayList<SMS> SMSsortants;


    public Client() {
    }

    public Client(String numTel, String numContrat, String nom, String prenom, Date dateContrat, Adresse adresse, String adresseMail)
    {
        this.numTel = numTel;
        this.numContrat = numContrat;
        this.nom = nom;
        this.prenom = prenom;
        this.dateContrat = dateContrat;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.etat = Etat.ACTIF;
        appelsEntrants = new ArrayList<>();
        appelsSortants = new ArrayList<>();
	SMSsortants = new ArrayList<>()
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

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
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
    
    public boolean egale(Client c)
    {
    	return (this.numTel.equals(c.getNumTel()));
    }
	//we can put those two mb3d fi main so we can use it fi adresse too 
    static boolean verifChaineAlphabetique(String input)
    {
    	String regex = "[\\sA-Za-z]+";
    	if(input.matches(regex))
    		return true;
    	return false;
    }
    static boolean verifNumTel(String input)
    {
    	String regex = "[0-9]+";
    	if(input.matches(regex))
    		return true;
    	return false;
    }

    public void saisir()
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.print("Nom:");
            nom = scan.nextLine();
            if(verifChaineAlphabetique(nom))
                break;
            System.out.println("Les caracteres speciaux ne sont pas autorise. Reessayez");
        }
        while(true)
        {
            System.out.print("prenom:");
            prenom = scan.nextLine();
            if(verifChaineAlphabetique(prenom))
                break;
            System.out.println("Les caracteres speciaux ne sont pas autorise. Reessayez");
        }

        while(true)
        {
            System.out.print("numero telephone :0");
            numTel ="0"+scan.nextLine();
            if(verifNumTel(numTel) && numTel.length()==10)
                break;
            System.out.println("numero non valide  Reessayez");
        }
            System.out.print("numero de contrat:");
            numContrat=scan.nextLine();
            
            adresse=new Adresse();
            adresse.saisir();
            System.out.print("AdressMail:");
            adresseMail=scan.nextLine();
         
 
    }
    

    /*public abstract void appeler();

    public abstract void recevoirAppel();

    public abstract boolean enEcheanceDePaiement();*/




}
