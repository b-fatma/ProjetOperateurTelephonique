package projet;

import java.time.Duration;
import java.util.Comparator;
import java.util.Scanner;

import projet.Adresse.Wilaya;
import projet.Client.Etat;

public class MainProgram {


	public static int  menu()
	{
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\nMenu:\n");
			System.out.println("1-Remplissage automatique des donnees ");
			System.out.println("2-Gestion d'operateur ");
			System.out.println("3-Gestion des clients");
			System.out.println("4-Gestion des factures");
			System.out.println("5-Gestion des Bonus");
			System.out.println("6-Quitter");
			System.out.print("Choisissez un programme du menu ci dessus: ");
			int option = scan.nextInt();
			scan.nextLine();
			while(option < 1 || option > 6)// forcer l'utilisateur a  saisir un entier valide
			{
				System.out.print("Entrez un numero figurant dans le menu (1-6): ");
				option = scan.nextInt();
				scan.nextLine();
			}
			return option;
		}
	}
	
	public static void executionChoixMenu(int option)
	{
		switch (option)
		{
			case 1 : 
				//traitement de remplissage auto 
				break;
			case 2 : // Menu Gestion d'operateur
				executionChoixOperateur(operateurMenu());
				break;
			case 3 :// Menu Gestion des Clients
				executionChoixClient(clientMenu());
				break;
			case 4 :// Menu Gestion des factures
				executionChoixFacture(factureMenu());
				break;
			case 5 :  // Menu Gestion des Bonus
				executionChoixBonus(bonusMenu()); 
				break;
                 
			case 6 :  //Quitter
                break;
					default:
						System.out.println("Choix incorrect");
						break;
			    }
				
		}
	
	public static int  operateurMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion d'operateur :\n");
		System.out.println("1-Ajouter un point de vente" );
		System.out.println("2-Supprimer un point de vente ");
		System.out.println("3-modifier un point de vente");
		System.out.println("4-Changer pourcentage de coverture ");
		System.out.println("5-Affichage d'information ");
		System.out.println("6-Quitter");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 6)// forcer l'utilisateur a  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-6): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	public static void modifierPointDeVente(PointDeVente pointDevente)
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("tapez ce que vous voulez changer |Type| |numero| |adressr|");
		String a=scan.next();
		switch(a)
		{
		case"Type" :
			System.out.println("Saisir le type ");
         operateur.modifierTypePV(pointDevente);
			break;
		case "numero":
			System.out.println("Saisir le numero ");
			operateur.modifierNumPV(pointDevente);
			break;
		case "adresse":
			System.out.println("Saisir l'adresse ");
			operateur.modifierAdressePV(pointDevente);
			break;
			default :
			       System.out.println("non valide");
		}
	}
	
	public static void modifierClient()
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("tapez ce que vous voulez changer |adresse| |debloque|");
		String choix=scan.next();
		String num=PointDeVente.saisirNum();
		switch(choix)
		{
		case "adresse" :
         operateur.numeroToClient(num).modifierAdresse();
			break;
		case "debloque":
			operateur.numeroToClient(num).setEtat(Etat.ACTIF);
			break;

		}
	}		
	public static String saisirNom()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Donne le nom de Point de vente pour changer");
		String nom= scan.next();
		return nom;
	}
	public static void executionChoixOperateur(int option)
	{
		switch (option)
		{
			case 1 : //Ajouter un point de vente
				PointDeVente pointdevente= new PointDeVente();
				pointdevente.saisir();
				operateur.ajouterPV(pointdevente);
				break;
			case 2 : //suppression d'un point de vente
				
				       operateur.supprimerPV(operateur.nomToPointDeVente(saisirNom()));
				break;
			case 3 ://modification de point de vente
				modifierPointDeVente(operateur.nomToPointDeVente(saisirNom()));
				break;
			case 4 ://modification pourcentage 
			 operateur.changerPourcentage();
				break;
			case 5 :  // Affichage information 
                
				break;
                 
			case 6 :  //Quitter
                break;
					default:
						System.out.println("Choix incorrect");
						break;
			    }
				
		}
	
	public static int  clientMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion des clients :\n");
		System.out.println("1-Ajouter numero " );
		System.out.println("2-Supprimer numero ");
		System.out.println("3-Modifier numero ");
		System.out.println("4-ajouter un appel ");
		System.out.println("5-ajouter un SMS ");
		System.out.println("6-List de Client par type d'abonnement");
		System.out.println("7-List numeros bloques");
		System.out.println("8-List numeros relances");
		System.out.println("9-List numeros par Wilaya");
		System.out.println("10-Affichage information pour un Client");
		System.out.println("11-List des appels pour un Client");
		System.out.println("12-Quitter");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 12)// forcer l'utilisateur a  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-12): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	
	public static void executionChoixClient(int option)
	{
		switch (option)
		{
			case 1 : //Ajouter un numero
				operateur.AjoutClientParSaisie();
				break;
				
			case 2 : //suppression d'un numero
				       operateur.supprimerClient(PointDeVente.saisirNum());
				break;
				
			case 3 ://modification d'un numero
				modifierClient();
				break;
				
			case 4 ://ajouter un appel
				
			
				break;
				
			case 5 :  //ajoiuter un SMS
                 
				break;
                 
			case 6 :  //list de client par type d'abonnement
               operateur.afficherParType(Abonnement.saisirAbonnement());
				break;
			case 7://list numeros bloques
				operateur.afficherListeBlocages();
				break;
			case 8: //list numeros relances
				operateur.afficherListeRappels();
				break;
			case 9: //list numeros par wilaya
			    operateur.afficherParWilaya(Wilaya.saisirWilaya());
				break;
			case 10://affichage d'information pour un Client
				operateur.numeroToClient(PointDeVente.saisirNum()).afficher();
				break;
			case 11://List d'appel et SMS pour un Client
				Scanner scan= new Scanner(System.in);
				System.out.println("si vous voulez preciser la date tapez 1, 0 si non ");
				int choix=scan.nextInt();
				switch(choix)
				{
				case 0:// si sans date:
				operateur.afficherAppels(PointDeVente.saisirNum());
				break;
				
				case 1://si avec date
					operateur.afficherAppels(PointDeVente.saisirNum(), Operateur.saisirDate(), Operateur.saisirDate());
				      break;
				default:
					System.out.println("Choix non valide");
				}
				break;
		
			case 12: //Quitter
				break;
					default:
						System.out.println("Choix incorrect");
						break;
			    }
				
		}
	public static int  factureMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion des factures :\n");
		System.out.println("1-Etablir facture pour un client " );
		System.out.println("2-affichage les client arrives a echeance de paiement  ");
		System.out.println("3-toutes les factures en instance de paiement  ");
		System.out.println("4-relancer les numero pour les rechargements/paiement ");
		System.out.println("5-Quitter");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 5)// forcer l'utilisateur a  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-5): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}

	public static void executionChoixFacture(int option)
	{
		switch (option)
		{
		case 1://Facture pour un Client
			 operateur.etablirFacture(PointDeVente.saisirNum());
			break;
		case 2://List de client a echance de paiement 
			operateur.afficherNumeros_echeance();
			break;
		case 3: //List des facture en instance de paiement 
			operateur.afficherFactures_instance();
			break;
			
		case 4:// relancer les numero pour les rechargements/paiements
			operateur.relancerNumeros();
			break;
		case 5:  //Quitter
            
			break;
					default:
						System.out.println("Choix incorrect");
						break;
			    }
				
		}
	

	public static int  bonusMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion des bonus :\n");
		System.out.println("1-Affecter bonus a des clients " );
		System.out.println("2-afficher les client ayant des bonus  ");
		System.out.println("3-Quitter ");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 3)// forcer l'utilisateur a  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-3): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	public static void executionChoixBonus(int option)
	{
		switch (option)
		{
		case 1://affecter bonus a des clients
			break;
		case 2://List de client  ayant beneficie de bonus
			
			break;
		case 3: //Quitter 			
			break;

					default:
						System.out.println("Choix incorrect");
						break;
			    }
				
		}
	static Operateur operateur = new Operateur();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
    

  }
}
