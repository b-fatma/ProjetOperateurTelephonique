package projet;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Appel
{
	enum TypeAppel {ENTRANT, SORTANT};
    private String numero;
    private LocalDate date;
    private LocalTime heure;
    private Duration duree;
    private TypeAppel type;

    public Appel() {}

    public Appel(String numero, LocalDate date, LocalTime heure, Duration duree)
    {
        this.numero = numero;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
    }
    
    

    public TypeAppel getType() {
		return type;
	}

	public void setType(TypeAppel type) {
		this.type = type;
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

    public long calculerMontant(int tarifUnite)
    {
        return (duree.toMinutes() * tarifUnite);
    }
    
    
    @Override
	public String toString() {
		return "Numero=" + numero + ", Date=" + date.toString() + ", Heure=" + heure.toString() + ", Duree=" + duree.toString();
	}
    
    public void afficher()
    {
    	System.out.println(this.toString());
    }

	public boolean appartient(LocalDate d1, LocalDate d2)
    {
        return (this.date.isAfter(d1)
        		&& this.date.isBefore(d2));
    }
	
	public void saisir()
	{
	    Scanner scan=new Scanner(System.in);
		
	    this.numero=PointDeVente.saisirNum();
	    System.out.print("Durée en secondes: ");
	    this.duree=Duration.ofSeconds(scan.nextLong());
	    this.date=LocalDate.now();
	    this.heure=LocalTime.now();	
	}


}
