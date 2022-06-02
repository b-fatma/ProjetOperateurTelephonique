package projet;

import java.time.LocalDate;

public class CarteDeRecharge
{
    private String numCarte;
    private LocalDate dateDeValidite;
    private static int dureeDeValidite = 3;
    private float montant;
    private boolean active;
    
    public static int getDureeDeValidite()
    {
    	return dureeDeValidite;
    }
    
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
