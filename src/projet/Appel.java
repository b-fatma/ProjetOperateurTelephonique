package projet;

import java.time.LocalDateTime;



public class Appel
{
    private String numero;
    private LocalDateTime date_heure;
    private int duree;

    public Appel() {}

    public Appel(String numero, LocalDateTime date, int duree)
    {
        this.numero = numero;
        this.date_heure = date;
        this.duree = duree;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(LocalDateTime date_heure) {
        this.date_heure = date_heure;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int calculerMontant(int tarifUnite)
    {
        return (duree * tarifUnite);
    }


}
