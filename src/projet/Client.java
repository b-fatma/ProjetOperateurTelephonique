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
    }


    public void modifierAdresse()
    {
        adresse.modifier();
    }

    /*public abstract void appeler();

    public abstract void recevoirAppel();

    public abstract boolean enEcheanceDePaiement();*/




}
