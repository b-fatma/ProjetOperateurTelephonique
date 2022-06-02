package projet;

import java.time.LocalDate;

public class Blocage 
{
	private String numTel;
	private LocalDate dateBlocage;
	private String motifBlocage;
	
	Blocage(String numTel, LocalDate dateBlocage, String motifBlocage)
	{
		this.dateBlocage = dateBlocage;
		this.motifBlocage = motifBlocage;
		this.numTel = numTel;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public LocalDate getDateBlocage() {
		return dateBlocage;
	}

	public void setDateBlocage(LocalDate dateBlocage) {
		this.dateBlocage = dateBlocage;
	}

	public String getMotifBlocage() {
		return motifBlocage;
	}

	public void setMotifBlocage(String motifBlocage) {
		this.motifBlocage = motifBlocage;
	}

	@Override
	public String toString() {
		return "Blocage [Numero: " + numTel + ", Date de blocage: " + dateBlocage + ", Motif: " + motifBlocage + "]";
	}
	
	public void afficher()
	{
		System.out.println(this.toString());
	}
	
	
	
	

}
