package projet;

import java.time.LocalDate;

import projet.Appel.TypeAppel;

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

    public float calculerMontant()
    {
    	return ((getForfaitfixe()+this.getMontant())*(1+getTVA()));
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
    			+"\nDate: " + LocalDate.now().toString()
    			+"\nNumero de telephone: " + getNumTel()
    			+"\nAbonnement: " + getTypeAbon()
    			+"\nNumero de contrat: " + getNumContrat()
    			+"\nDate debut de forfait: " + getDateContrat().toString()
    			+"\nMontant a payer: " + this.calculerMontant() +"\n");
    }

    public void appeler(int tarif, Appel appel)
    {
    	appel.setType(TypeAppel.SORTANT);
    	montant += appel.calculerMontant(tarif);
    	this.getAppels().add(appel);
    }
    
    public void recevoirAppel(Appel appel)
    {
    	appel.setType(TypeAppel.ENTRANT);
    	this.getAppels().add(appel);
    }


}
