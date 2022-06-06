package projet;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;

import projet.Appel.TypeAppel;

public class Client_Prepaye extends Client
{

    private HashMap<String, LocalDate> CartesChargees;
    private float solde;

    public Client_Prepaye()
    {
    	super();
    	super.delai_paiement = 90;
    	super.setTypeAbon(Abonnement.PREPAYE);
        this.solde = 0;
        this.CartesChargees = new HashMap<>();
    }

    public Client_Prepaye(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail) {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        super.delai_paiement = 90;
    	super.setTypeAbon(Abonnement.PREPAYE);
        this.solde = 0;
        this.CartesChargees = new HashMap<>();
    }

    public void recharger(CarteDeRecharge c)
    {
        if(c.disponible())
        {
            CartesChargees.put(c.getNumCarte(), LocalDate.now());
            c.activerCarte();
            this.solde += c.getMontant();
        }
        else
            System.out.println("Impossible de charger cette carte!");
    }
    
    
    
    public LocalDate derniereDateRecharge()
    {
    	return Collections.max(CartesChargees.values());
    }
    
    public boolean echeanceDePaiement()
    {
    	return(solde == 0 && LocalDate.now().isAfter(this.derniereDateRecharge().plusDays(CarteDeRecharge.getDureeDeValidite()).plusDays(delai_paiement)));
    }
    
    public boolean instanceDePaiement()
    {
    	return(solde == 0 && LocalDate.now().isAfter(this.derniereDateRecharge().plusDays(CarteDeRecharge.getDureeDeValidite())));
    }
    
    
    public String Facture()
    {
    	return ("\n _______ FACTURE ______ \n"
    			+"Date: " + LocalDate.now().toString()
    			+"Numero de telephone: " + getNumTel()
    			+"Abonnement: " + getTypeAbon()
    			+"Numero de contrat: " + getNumContrat()
    			+"Date debut de forfait: " + getDateContrat().toString()
    			+"Date de la derniere recharge: " + this.derniereDateRecharge().toString()
    			+"\n");
    }
    
    public void appeler(int tarif, Appel appel)
    {
    	appel.setType(TypeAppel.SORTANT);
    	solde -= appel.calculerMontant(tarif);
    	this.getAppels().add(appel);
    }
    
    public void recevoirAppel(Appel appel)
    {
    	appel.setType(TypeAppel.ENTRANT);
    	this.getAppels().add(appel);
    }
   
}
