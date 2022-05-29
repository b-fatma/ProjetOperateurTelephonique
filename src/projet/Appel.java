package projet;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


public class Appel
{
	public enum TypeAppel{Entrant,Sortant}
    private String numero;
    private LocalDate date;
    private LocalTime heure;
    private Duration duree;
    private TypeAppel typeAppel;

    public Appel() {}

    public Appel(String numero, LocalDate date, LocalTime heure, Duration duree,TypeAppel typeAppel)
    {
        this.numero = numero;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.typeAppel=typeAppel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }
    public TypeAppel getTypeAppel()
    {
    	return typeAppel;
    }
    public void setTypeAppel(TypeAppel typeAppel)
    {
    	 this.typeAppel=typeAppel;
    }

    public long calculerMontant(int tarifUnite)
    {
        return (duree.toMinutes() * tarifUnite);
    }
    
    public boolean appartient(LocalDate d1, LocalDate d2)
    {
        return (this.date.isAfter(d1)
        		&& this.date.isBefore(d2));
    }

    public void affichage()
    {
    	System.out.println("numero: "+numero);
    	System.out.println("heure: "+heure);
    	System.out.println("Date: "+date);
    	System.out.println("durré d'appel : "+duree);
    	System.out.println("Type d'appel: "+typeAppel);
    	
    }

}
