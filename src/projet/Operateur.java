package projet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import projet.Adresse.Wilaya;
import projet.Client.Etat;

public class Operateur
{
    private String nom;
    private ArrayList<PointDeVente> PV;
    private HashMap<Wilaya, Float> PC;
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
        this.Blocages= new ArrayList<>();
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
     * Supprimer un point de vente s il existe
     */
    public void supprimerPV(PointDeVente pointDeVente)
    {
        if(!PV.remove(pointDeVente))
        	System.out.print("Ce point de vente n existe pas"); 	
    }
    
    
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
    
    
    
    
    

}
