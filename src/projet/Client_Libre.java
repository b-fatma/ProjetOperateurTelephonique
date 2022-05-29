package projet;

import java.time.LocalDate;

public class Client_Libre extends Client
{
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
    }

    public Client_Libre(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail)
    {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        this.montant = 0;
    }

    public void appeler()
    {

    }

    public void recevoirAppel()
    {

    }
    




}
