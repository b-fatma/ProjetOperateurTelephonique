package projet;

import java.time.LocalDate;

public class Client_Libre extends Client
{
	private static final int duree = 2;
    private final static float forfaitFixe = 500;
    private float montant;
    private static float TVA =  0.19f;
    

    public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public static float getTVA() {
		return TVA;
	}

	public static void setTVA(float tVA) {
		TVA = tVA;
	}

	public static float getForfaitfixe() {
		return forfaitFixe;
	}

	public Client_Libre()
    {
        super();
        super.delai_paiement = 30;
        super.setTypeAbon(Abonnement.LIBRE);
        this.montant = 0;
    }

    public Client_Libre(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail)
    {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        super.delai_paiement = 30;
        super.setTypeAbon(Abonnement.LIBRE);
        this.montant = 0;
    }

    public void appeler()
    {

    }

    public void recevoirAppel()
    {

    }
    
    public boolean echeanceDePaiement()
    {
    	return(LocalDate.now().isAfter(super.dateContrat.plusDays(delai_paiement).plusMonths(duree)));
    }
    
    
    public boolean instanceDePaiement()
    {
    	return(LocalDate.now().isAfter(super.dateContrat.plusMonths(duree)));
    }
    
    public String Facture()
    {
    	return ("\n _______ FACTURE ______ \n"
    			+"Date: " + LocalDate.now().toString()
    			+"Numero de telephone: " + getNumTel()
    			+"Abonnement: " + getTypeAbon()
    			+"Numero de contrat: " + getNumContrat()
    			+"Date debut de forfait: " + getDateContrat().toString()
    			+"Montant a payer: " + montant +"\n");
    }



}
