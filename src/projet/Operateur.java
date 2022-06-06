package projet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import projet.Adresse.Wilaya;


public class Operateur
{
    private String nom;
    private ArrayList<PointDeVente> PV;
    private HashMap<Wilaya,Float> PC;
    private ArrayList<Client> CL;
    private ArrayList<Blocage> Blocages;
    private final static int tarif_int = 4;
    private final static int tarif_ext = 4;

    public Operateur()
    {

    }



    public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
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
    	for(Wilaya w : PC.keySet())
    	{
    		System.out.println("Wilaya: " + w.toString() + " Pourcentage: " + PC.get(w)*100 +"%");
    	}
    }
    
    
    
/* GESTION DES POINTS DE VENTES */
    
    
    /* REVIEWED
     * ajouter un point de vente (par programme)
     */
    public void ajouterPV(PointDeVente p)
    {
    	if(!this.pointVenteExiste(p))
            PV.add(p);
        else
        	System.out.println("Ce point de vente existe deja!");
    }
    
    /* REVIEWED
     * verifier si un point de vente existe chez cet operateur
     */
    public boolean pointVenteExiste(PointDeVente pointDeVente)
    {
    	for(PointDeVente p : PV)
    		if(pointDeVente.egale(p))
    			return true;
    	return false;
    }
    
    /* REVIEWED
     * Modifier le type d'un point de vente donne
     */
    public void modifierTypePV(String nom)
    {
    	Iterator<PointDeVente> i = PV.iterator();
    	PointDeVente j = null;
    	while(i.hasNext())
    	{
    	    j = i.next();
    	    if(j.getNom().equals(nom))
    	    {
    	    	j.modifierType();
    	    	System.out.println("Type modifié avec succès.\n");
    	    	return;
    	    }
    	}
    	System.out.println("Echec! Point de vente non trouvé.\n");
    }
    
    /* REVIEWED
     * Modifier le numero de telephone d un point de vente donne
     */
    public void modifierNumPV(String nom)
    {
    	Iterator<PointDeVente> i = PV.iterator();
    	PointDeVente j = null;
    	while(i.hasNext())
    	{
    	    j = i.next();
    	    if(j.getNom().equals(nom))
    	    {
    	    	j.modifierNum();
    	    	System.out.println("Numéro modifié avec succès.\n");
    	    	return;
    	    }
    	}
    	System.out.println("Echec! Point de vente non trouvé.\n");
    }
    
    /* REVIEWED
     * Modifier l adresse d un point de vente donne
     */
    public void modifierAdressePV(String nom)
    {
    	Iterator<PointDeVente> i = PV.iterator();
    	PointDeVente j = null;
    	while(i.hasNext())
    	{
    	    j = i.next();
    	    if(j.getNom().equals(nom))
    	    {
    	    	j.modifierAdresse();
    	    	System.out.println("Adresse modifi�e avec succ�s.\n");
    	    	return;
    	    }
    	}
    	System.out.println("Echec! Point de vente non trouv�.\n");
    }
    
    /* REVIEWED
     * Supprimer un point de vente s il existe
     */
    public void supprimerPV(String nom)
    {
    	for(int i = 0; i < PV.size(); i++)
    	{
    		if(PV.get(i).getNom().equals(nom))
    		{
    			PV.remove(i);
    			System.out.println("Point de vente supprimé avec succès.\n");
    			return;
    		}
    	}
    	System.out.println("Echec! Point de vente non trouvé.\n"); 	
    }    
        /*
     * Method qui retourne pointDeVente par nom
     */
    public PointDeVente nomToPointDeVente(String nom)
    {
    	for(PointDeVente pointDeVente : PV)
    	{
    		if(pointDeVente.getNom().equals(nom))
    			return pointDeVente;		   
    	}
    	return null;
    }
    
   
    
    /* GESTION DES CLIENTS */
    
    /* REVIEWED
     * Methode qui permet d ajouter un client 
     */
    public void ajouterClient(Client client)
    {
    	if(!this.clientExiste(client))
    		CL.add(client);
    	else
    		System.out.println("Ce client existe deja!");
    }
    
    
    /* REVIEWED
     * M�thode qui retourne le client associ� � un num�ro donn�
     */
    public Client numeroToClient(String numTel)
    {
    	for(Client client : CL)
    	{
    		if(client.getNumTel().equals(numTel))
    			return client;		   
    	}
    	return null;
    }
    
    
    /* REVIEWED
     * Demande de type 
     * + création et saisie client 
     * + ajout client 
     */
    public void AjoutClientParSaisie()
    {
    	Abonnement type = Abonnement.saisirAbonnement();
    	Client c  = null;
    	switch(type)
    	{
    	case FORFAITAIRE:
    		c = new Client_Forfaitaire();
    	    break;
    	case LIBRE:
    		c = new Client_Libre();
    	    break;
    	case PREPAYE:
    		c = new Client_Prepaye();
    	    break;
    	}
    	c.saisir();
    	this.ajouterClient(c);
    }
    
    
    
    
    
    /* REVIEWED
     * verifier si un client est abonné chez cet operateur
     */
    public boolean clientExiste(Client client)
    {
    	for(Client c : CL)
    		if(client.egale(c))
    			return true;
    	return false;
    }
    
    /* REVIEWED
     * Afficher les clients d une wilaya donnee 
     * (par rapport a l adresse)
     */
    public void afficherParWilaya(Wilaya w)
    {
    	for(Client client : CL)
    	{
    		if(client.getAdresse().getWilaya().equals(w))
                client.afficher();
    	}
    }
    
    /* REVIEWED
     * Afficher les clients abonnés à un type donné
     */
    
    public void afficherParType(Abonnement type)
    {
    	for(Client client : CL)
        {
    		if(client.getTypeAbon().equals(type))
    			client.afficher();  
    	}
    }
    
    /* REVIEWED
    * Afficher le numéro des clients bloqués, le motif et la date du blocage
    */
    public void afficherListeBlocages()
    {
    	for(Blocage blocage : Blocages)
    		blocage.afficher();
    }
    
    
    /* REVIEWED
     * La liste des numéros relancés pour paiement ou rechargement avec les dates de rappel
     */
    public void afficherListeRappels()
    {
    	for(Client client : CL)
    	{
    		if(client.getDatesRappels().size()>0)
    		{
    			client.afficher();
    			System.out.println("Les dates de relancement: ");
    			client.afficherRappels();
    		}   
    	}
    }
   
    
    /* REVIEWED 
     * Afficher les appels d'un numero donné (sans préciser la durée)
     */
    public void afficherAppels(String numero)
    {
    	Client c = this.numeroToClient(numero);
    	if(c != null)
    		c.afficherAppels();
    	else
    		System.out.println("Ce client n existe pas");
    }
    
    /* REVIEWED 
     * Afficher les appels entre 2 dates d'un numero donné 
     */
    public void afficherAppels(String numero, LocalDate d1, LocalDate d2)
    {
    	Client c = this.numeroToClient(numero);
    	if(c != null)
    		c.afficherAppels(d1, d2);
    	else
    		System.out.println("Ce client n existe pas");
    }
   
    
    /* REVIEWED 
     * Suppression d un client donne
     */
    public void supprimerClient(String numero)
    {
    	Client c = this.numeroToClient(numero);
    	if(c == null)
    		System.out.println("Ce client n existe pas");
    	else
    	{
    		CL.remove(c);
    		System.out.println("Client supprimé avec succès.");
    	}
    }
     
    /*
     * Afficher les inforomations d'un numéro donné
     */
    public void afficherInfoNum(String numero)
    {
    	if(this.numeroToClient(numero) == null)
    		System.out.println("Ce numero n existe pas!");
        else
        	this.numeroToClient(numero).afficher();
    }
    
    /*
     * Afficher tous les numéros arrivés à échéance de paiement
     */
    public void afficherNumeros_echeance()
    {
    	int cmp = 1;
    	for(Client c : CL)
    	{
    		if(c.echeanceDePaiement())
    		{
    			System.out.println("\nNumero N°" + cmp + ": " + c.getNumTel());	
    		}
    	}
    }
    
    /*
     * Afficher toutes les factures en instance de paiement
     */
    public void afficherFactures_instance()
    {
    	for(Client c : CL)
    	{
    		if(c.instanceDePaiement())
    		{
    			System.out.println(c.Facture());	
    		}
    	}
    }
    
    /*
     * Etablir facture pour un numéro donné
     */
    public void etablirFacture(String num)
    {
    	if(this.numeroToClient(num) == null)
    		System.out.println("Ce numero n existe pas!");
        else
        	System.out.println(this.numeroToClient(num).Facture());
    }
    
    /*
     * Relancer les numéros pour les rechargements/ paiements
     */
    public void relancerNumeros()
    {
    	for(Client c : CL)
    	{
    		if(c.instanceDePaiement() && c.getDatesRappels().size() < 3)
    		{
    			c.relancer();
    			System.out.println("Numero " + c.getNumTel() + " relancé");
    		}
    	}
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
        System.out.print("(jj/mm/aaaa): ");
		String dateSaisie = scan.next();
		while(!dateSaisie.matches("\\d{2}/\\d{2}/\\d{4}"))
		{
			System.out.println("Respectez le format (jj/mm/aaaa): ");
			dateSaisie = scan.next();
		}
		return stringToDate(dateSaisie);
	}  
	
	
/* GESTION DES APPELS */
	
	public void ajouterAppelSortant(String num)
	{
		Client c = this.numeroToClient(num);
		if(c != null)
		{
			Appel appel = new Appel();
			appel.saisir();
			
			Client destinataire = this.numeroToClient(c.getNumTel());
			if(destinataire != null)
			{
				c.appeler(tarif_int, appel);
				Appel appel2 = new Appel(c.getNumTel(), appel.getDate(), appel.getHeure(), appel.getDuree());
				destinataire.recevoirAppel(appel2);
			}
			else
			{
				c.appeler(tarif_ext, appel);
			}	
		}
		else
			System.out.println("Ce numéro n existe pas!");
	}
	
	public void ajouterAppelEntrant(String num)
	{
		Client c = this.numeroToClient(num);
		if(c != null)
		{
			Appel appel = new Appel();
			appel.saisir();
			
			c.recevoirAppel(appel);
		}
		else
			System.out.println("Ce numéro n existe pas!");
	}


//GESTION DES SMS
	public void ajouterSMS(String numTel)
	{

		Client c = this.numeroToClient(numTel);
		if(c != null)
		{
		SMS sms=new SMS();
	    sms.saisir();
		sms.setNum_exped(numTel);
		c.envoyerSMS(sms);
		}
		else
			System.out.println("Ce numéro n existe pas!");
	}
}

