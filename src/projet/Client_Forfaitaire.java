package projet;

import java.time.LocalDate;

import projet.Appel.TypeAppel;

public class Client_Forfaitaire extends Client
{
    private static final int duree = 2;
    private static final float montant_initial = 2300;
    private float montant;

    
    public static int getDuree() {
		return duree;
	}

	public static float getMontantInitial() {
		return montant_initial;
	}

	public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Client_Forfaitaire()
    {
        super();
        super.delai_paiement = 30;
        super.setTypeAbon(Abonnement.FORFAITAIRE);
        montant = montant_initial;
    }

    public Client_Forfaitaire(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail)
    {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        super.delai_paiement = 30;
        super.setTypeAbon(Abonnement.FORFAITAIRE);
        this.montant = montant_initial;
    }

    public boolean montantEpuise()
    {
        return (montant == 0);
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
    			+"\nMontant a payer: " + montant_initial +"\n");
    }
    
    public void appeler(int tarif, Appel appel)
    {
    	appel.setType(TypeAppel.SORTANT);
    	montant -= appel.calculerMontant(tarif);
    	this.getAppels().add(appel);
    }
    
    public void recevoirAppel(Appel appel)
    {
    	appel.setType(TypeAppel.ENTRANT);
    	this.getAppels().add(appel);
    }



}
