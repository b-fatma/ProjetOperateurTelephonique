package projet;

import java.time.LocalDate;

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
        montant = montant_initial;
    }

    public Client_Forfaitaire(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail)
    {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        this.montant = montant_initial;
    }

    public boolean montantEpuise()
    {
        return (montant == 0);
    }
    
    







}
