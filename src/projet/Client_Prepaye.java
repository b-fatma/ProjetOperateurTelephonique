package projet;

import java.time.LocalDate;
import java.util.HashMap;
public class Client_Prepaye extends Client
{
    public class CarteDeRecharge
    {
        private String numCarte;
        private LocalDate dateDeValidite;
        private static final int dureeDeValidite = 3;
        private float montant;
        private boolean active;

        public float getMontant() {
            return montant;
        }

        public void setMontant(float montant) {
            this.montant = montant;
        }

        public String getNumCarte() {
            return numCarte;
        }

        public void setNumCarte(String numCarte) {
            this.numCarte = numCarte;
        }

        public LocalDate getDateDeValidite() {
            return dateDeValidite;
        }

        public void setDateDeValidite(LocalDate dateDeValidite) {
            this.dateDeValidite = dateDeValidite;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public CarteDeRecharge()
        {}

        public CarteDeRecharge(String numCarte, LocalDate dateDeValidite, float montant)
        {
            this.numCarte = numCarte;
            this.dateDeValidite = dateDeValidite;
            this.montant = montant;
            this.active  = false;
        }

        public boolean disponible()
        {
            if(!active && dateDeValidite.isBefore(LocalDate.now()))
            {
                return true;
            }
            return false;
        }

        public void activerCarte()
        {
            this.active = true;
        }

    }


    private HashMap<String, LocalDate> CartesChargees;
    private float solde;

    public Client_Prepaye()
    {
        this.solde = 0;
        this.CartesChargees = new HashMap<>();
    }

    public Client_Prepaye(String numTel, String numContrat, String nom, String prenom, LocalDate dateContrat, Adresse adresse, String adresseMail) {
        super(numTel, numContrat, nom, prenom, dateContrat, adresse, adresseMail);
        this.solde = 0;
        this.CartesChargees = new HashMap<>();
        super.typeAbon=TypeAbon.Prepaye;
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
}
