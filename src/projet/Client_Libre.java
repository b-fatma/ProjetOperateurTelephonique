package projet;

import java.util.Date;

public class Client_Libre extends Client
{
    private final static float forfaitFixe = 500;
    private float montant;
    private static float TVA =  0.19f;

    public Client_Libre()
    {
        super();
    }

    public Client_Libre(String numTel, String numContrat, String nom, String prenom, Date dateContrat, Adresse adresse, String adresseMail)
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
