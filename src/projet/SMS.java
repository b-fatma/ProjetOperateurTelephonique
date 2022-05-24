package projet;

import java.time.LocalDateTime;

public class SMS 
{
    private String num_exped;
    private String num_dest;
    private LocalDateTime envoi;
    private String text;
    private String statut;
    
    public SMS()
    {
    	
    }
    
    public SMS(String num_expediteur, String num_destinataire, LocalDateTime envoi, String text,  String statut)
    {
    	this.num_dest = num_destinataire;
    	this.num_exped = num_expediteur;
    	this.envoi = envoi;
    	this.text = text;
    	this.statut = statut;
    }
    
	public String getNum_exped() {
		return num_exped;
	}
	public void setNum_exped(String num_expediteur) {
		this.num_exped = num_expediteur;
	}
	public String getNum_dest() {
		return num_dest;
	}
	public void setNum_dest(String num_destinataire) {
		this.num_dest = num_destinataire;
	}
	public LocalDateTime getEnvoi() {
		return envoi;
	}
	public void setEnvoi(LocalDateTime envoi) {
		this.envoi = envoi;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
    
    
    
}
