package projet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import projet.Adresse.Wilaya;
import projet.Client.Etat;
import project.Client.TypeAbon;
public class Operateur
{
    private String nom;
    private ArrayList<PointDeVente> PV;
    private HashMap<Wilaya,Float> PC;
    private ArrayList<Client> CL;
    private ArrayList<Blocage> Blocages;

    public Operateur()
    {

    }

    public Operateur(String nom)
    {
        this.nom = nom;
        this.PV = new ArrayList<>();
        this.PC = new HashMap<>();
        this.CL = new ArrayList<>();
        this.Blocages = new ArrayList<>();
    }
    
    public String toString()
    {
    	return ("Operateur: " + nom );
    }
    
    /* AFFICHAGES */
    
    public void afficherClients()
    {
    	for(Client c : CL)
    		System.out.println(c);
    }
    
    public void afficherPointsDeVente()
    {
    	for(PointDeVente p : PV)
    		System.out.println(p);
    }
    
    public void afficherBlocages()
    {
    	for(Blocage b : Blocages)
    		System.out.println(b);
    }
    
    public void afficherPourcentages()
    {
    	
    }
    
    
    
    /* GESTION DES POINTS DE VENTES */
    
    
    /*
     * ajouter un point de vente (par programme)
     */
    public void ajouterPV(PointDeVente p)
    {
    	if(!this.pointVenteExiste(p))
            PV.add(p);
        else
        	System.out.println("Ce point de vente existe deja!");
    }
    
    /*
     * verifier si un point de vente existe chez cet operateur
     */
    public boolean pointVenteExiste(PointDeVente pointDeVente)
    {
    	for(PointDeVente p : PV)
    		if(pointDeVente.egale(p))
    			return true;
    	return false;
    }
    
    /*
     * Modifier le type d'un point de vente donne
     */
    public void modifierTypePV(PointDeVente pointDeVente)
    {
    	for(PointDeVente p : PV)
    		if(pointDeVente.egale(p))
    			p.modifierType();
    		else
    			System.out.println("Ce point de vente n existe pas! ");
    }
    
    /*
     * Modifier le numero de telephone d un point de vente donne
     */
    public void modifierNumPV(PointDeVente pointDeVente)
    {
    	for(PointDeVente p : PV)
    		if(pointDeVente.egale(p))
    			p.modifierNum();
    		else
    			System.out.println("Ce point de vente n existe pas! ");
    }
    
    /*
     * Modifier l adresse d un point de vente donne
     */
    public void modifierAdressePV(PointDeVente pointDeVente)
    {
    	for(PointDeVente p : PV)
    		if(pointDeVente.egale(p))
    			p.modifierAdresse();
    		else
    			System.out.println("Ce point de vente n existe pas! ");
    }
    
    /*
     * Supprimer un point de vente s il existe
     */
    public void supprimerPV(PointDeVente pointDeVente)
    {
        if(!PV.remove(pointDeVente))
        	System.out.print("Ce point de vente n existe pas"); 	
    }   
    
   
    
    /* GESTION DES CLIENTS */
    
    /*
     * Methode qui permet d ajouter un client 
     */
    public void ajouterClient(Client client)
    {
    	if(!this.clientExiste(client))
    		CL.add(client);
    	else
    		System.out.println("Ce client existe deja!");
    }
    /*
     * Saisir Client p
     */
    public Client TypeClient()
    {
    	TypeAbon typeabon=this.getType();
    	switch(typeabon) 
    	{
    	case Forfaitaire: 
    		Client p=new Client_Forfaitaire();
    		return p;
    	
	case Libre: 
		Client p2=new Client_Libre();
		return p2;
	
case Prepaye: 
	Client p3=new Client_Prepaye();
	return p3;
        }
    	return null;
    		
    }
    public void saisirClient(Client p)
    {
    	p.saisir();
    }
    
    /*
     * Suppression d un client donne
     */
    public void supprimerClient(Client client)
    {
    	if(!CL.remove(client))
    		System.out.println("Ce client n existe pas");
    }
    
    
    /*
     * verifier si un client est abonné chez cet operateur
     */
    public boolean clientExiste(Client client)
    {
    	for(Client c : CL)
    		if(client.egale(c))
    			return true;
    	return false;
    }
    
    /*
     * Afficher les clients d une wilaya donnee 
     * (par rapport a l adresse)
     */
    public void afficherParWilaya(Wilaya w)
    {
    	for(Client client : CL)
    	{
    		if(client.getAdresse().getWilaya().equals(w))
                client.affichage();
    	}
    }
    
    /* Afficher les numéro de client bloqué et la motif et la date
    * 
    */
   public void affichageListBlocage()
   {
   	for(Blocage blocage : Blocages)
   	{
   		blocage.affichage();
   	}
   }
   
   /* Afficher les numéro de client bloqué et la motif et la date
   * 
   */
  public TypeAbon getType()
  {
	
	  while(true) {
		  System.out.println("Entrez un type valide ");
		  Scanner scan=new Scanner(System.in);
          String typAb=scan.next();
switch(typAb) {
case "Forfaitaire":
	return TypeAbon.Forfaitaire;
case "Libre":
	return TypeAbon.Libre;
case "Prepaye":
	return TypeAbon.Prepaye;
	
               }

                  }
  }
  
  public void affichageParType(TypeAbon typ)
  {
	  for(Client client : CL)
  	{
  		if(client.getTypeAbon().equals(typ))
  		{
  			 client.affichage();

  		}   
  	}
  }
  
  
  
  
  
  /*
   * 
   */
  public void affochageListRelance()
  {
	  for(Client client : CL)
  	{
  		if(client.getDateRappel().size()>0)
  		{
  			System.out.println(client);
  		}   
  	}
  }
  /*
   * rechercher numero et affiche List d'appel Sortant et Entrant
   */
  
  public void afficheAppel(String numeTel,LocalDate date1, LocalDate date2)
  {
	  long duree=0;
	  
	  ArrayList<Appel> appel=chercherClient(numeTel).getAppel();
	  for(Appel ap : appel)
  	{
  		if(ap.appartient(date1, date2))
  		{
  			ap.affichage();
  			duree=duree+ap.getDuree().getSeconds();
  		}		   
  	}
	
	 System.out.println(Duration.ofSeconds(duree));
	 
  }
  
    /*
     * Recherche et affichage d un numero donne
     */
    public Client chercherClient(String numTel)
    {
    	for(Client client : CL)
    	{
    		if(client.getNumTel().equals(numTel))
    		{
    			return client;
    		}		   
    	}
    	
    	return null;
    }
    public void afficherInfoNum(String numTel)
    {
    	
        if(chercherClient(numTel)==null)
    		System.out.println("Ce numero n existe pas!");
        else
        	chercherClient(numTel).affichage();
    }
    
    
    
    /* GESTION DES POURCENTAGES DES COUVERTURES */
    
    
    /*
     * methode qui permet a l utilisateur de changer le pourcentage
     * de couverture d une wilaya donne
     */
    public void changerPourcentage()
    {
    	Scanner scan = new Scanner(System.in);
    	
    	Wilaya w = Wilaya.saisirWilaya();
    	System.out.print("Le nouveau pourcentage de couverture: ");
    	Float p = scan.nextFloat();
        PC.replace(w, p);
    }
    
    public void initialiserPourcentages()
    {
        PC.put(Wilaya.ALGER, 1f);
        PC.put(Wilaya.ANNABA, 0.2f);
        PC.put(Wilaya.BEJAIA, 0.4f);
        PC.put(Wilaya.CONSTANTINE, 0.6f);
        PC.put(Wilaya.ORAN, 0.7f);
        PC.put(Wilaya.SKIKDA, 0.85f);
    }
    
    
    public static LocalDate stringToDate(String input) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(input, dateFormat);
	    return date ;
	}
	
	public static LocalDate saisirDate()
	{
		Scanner scan = new Scanner(System.in);
        System.out.println("Entrez la date (jj/mm/aaaa): ");
		String dateSaisie = scan.next();
		while(!dateSaisie.matches("\\d{2}/\\d{2}/\\d{4}"))
		{
			System.out.println("Respectez le format (jj/mm/aaaa): ");
			dateSaisie = scan.next();
		}
		return stringToDate(dateSaisie);
	}  
    
    
    
    
    

}
