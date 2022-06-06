package projet;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;

import projet.Adresse.Wilaya;
import projet.Client.Etat;
import projet.PointDeVente.Type;

public class MainProgram {


	public static int  menu()
	{
		Scanner scan = new Scanner(System.in); 
		System.out.println("\nMenu:\n");
		System.out.println("1-Remplissage automatique des donnees.\n" 
		        + "2-Gestion de l'operateur.\n"
				+ "3-Gestion des clients.\n"
		        + "4-Gestion des factures.\n"
				+ "5-Gestion des Bonus.\n"
		        + "6-Quitter.\n");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 6)// forcer l'utilisateur aÂ  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-6): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;		
	}
	
	public static int  operateurMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion de l'operateur :\n");
		System.out.println("1-Ajouter un point de vente\n"
				+ "2-Supprimer un point de vente.\n"
				+ "3- Modifier un point de vente.\n"
				+ "4- Changer le pourcentage de coverture d'une wilaya\n"
				+ "5- Afficher les points de vente.\n"
				+ "6- Afficher les pourcentages de couverture.\n"
				+ "7- Afficher les clients.\n"
				+ "8- Quitter.\n");
		
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 8)// forcer l'utilisateur aÂ  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-8): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	
	
	public static int  clientMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion des clients :\n");
		System.out.println("1- Ajouter un numéro." );
		System.out.println("2- Supprimer un numéro.");
		System.out.println("3- Modifier un numéro.");
		System.out.println("4- Ajouter un appel entrant.");
		System.out.println("5- Ajouter un appel sortant.");
		System.out.println("6- Liste des clients par type d'abonnement");
		System.out.println("7- Liste des numeros bloques");
		System.out.println("8- Liste des numeros relances");
		System.out.println("9- Liste des numeros par Wilaya");
		System.out.println("10- Affichage information pour un Client");
		System.out.println("11- Liste des appels pour un Client");
		System.out.println("12- Quitter");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 12)// forcer l'utilisateur aÂ  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-12): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	
	public static int  factureMenu()
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("\n Gestion des factures :\n");
		System.out.println("1- Etablir facture pour un client " );
		System.out.println("2- Afficher les client arrives a echeance de paiement  ");
		System.out.println("3- Afficher toutes les factures en instance de paiement  ");
		System.out.println("4- Relancer les numero pour les rechargements/paiement ");
		System.out.println("5- Quitter");
		System.out.print("Choisissez un programme du menu ci dessus: ");
		int option = scan.nextInt();
		scan.nextLine();
		while(option < 1 || option > 5)// forcer l'utilisateur aÂ  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-5): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
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
		while(option < 1 || option > 3)// forcer l'utilisateur aÂ  saisir un entier valide
		{
			System.out.print("Entrez un numero figurant dans le menu (1-3): ");
			option = scan.nextInt();
			scan.nextLine();
		}
		return option;
	}
	
	
	public static void executionChoixMenu(int option)
	{
		int choix;
		switch (option)
		{
			case 1 : 
				//traitement de remplissage auto 
				Remplir(operateur);
				break;
				
			case 2 : // Menu Gestion d'operateur
				do
				{
					choix = operateurMenu();
					executionChoixOperateur(choix);
				}while(choix != 8);
				break;
				
			case 3 :// Menu Gestion des Clients
				do
				{
					choix = clientMenu();
					executionChoixClient(choix);
				}while(choix != 12);
				break;
				
			case 4 :// Menu Gestion des factures
				do
				{
					choix = factureMenu();
					executionChoixFacture(choix);
				}while(choix != 5);
				break;
				
			case 5 :  // Menu Gestion des Bonus
				do
				{
					choix = bonusMenu();
					executionChoixBonus(choix);
				}while(choix != 3);
				break;
                 
			case 6 :  //Quitter
                break;
		}
	}
	
	
	public static void modifierPointDeVente(String nom)
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("tapez ce que vous voulez changer |type| |numero| |adresse|");
		String a=scan.next();
		switch(a)
		{
		case "type" :
			System.out.println("Saisir le type ");
            operateur.modifierTypePV(nom);
			break;
		case "numero":
			System.out.println("Saisir le numero ");
			operateur.modifierNumPV(nom);
			break;
		case "adresse":
			System.out.println("Saisir l'adresse ");
			operateur.modifierAdressePV(nom);
			break;
		default :
			 System.out.println("non valide");
		}
	}
	
	public static void modifierClient()
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Entrez ce que vous voulez changer |adresse| |debloquer|");
		String choix=scan.next();
		String num=PointDeVente.saisirNum();
		switch(choix)
		{
		case "adresse" :
         operateur.numeroToClient(num).modifierAdresse();
			break;
		case "debloquer":
			operateur.numeroToClient(num).setEtat(Etat.ACTIF);
			break;
		}
	}		
	public static String saisirNom()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Donnez le nom du point de vente: ");
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
			    operateur.supprimerPV(saisirNom());
				break;
				
			case 3 ://modification de point de vente
			    modifierPointDeVente(saisirNom());
				break;
				
			case 4 ://modification pourcentage 
			    operateur.changerPourcentage();
				break;
			case 5:  // Affichage information 
                operateur.afficherPointsDeVente();
				break;
				
			case 6: 
				operateur.afficherPourcentages();
                break;
                 
			case 7: 
				operateur.afficherClients();
                break;
			case 8:
				break;
					
			    }
				
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
				
			case 4 ://ajouter un appel entrant
				operateur.ajouterAppelEntrant(PointDeVente.saisirNum());
				break;
				
			case 5 :  //ajouter un appel sortant
                operateur.ajouterAppelSortant(PointDeVente.saisirNum());
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
				operateur.afficherInfoNum(PointDeVente.saisirNum());
				break;
				
			case 11://List d'appel et SMS pour un Client
				Scanner scan= new Scanner(System.in);
				System.out.print("Si vous voulez preciser la date tapez 1, 0 sinon: ");
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
		}			
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

		}
				
	}
	
	public static void Remplir(Operateur operateur)
	{
		operateur.initialiserPourcentages();
		
		operateur.ajouterPV(new PointDeVente("PV1", Type.PRINCIPAL, new Adresse(1, "a", "a", Wilaya.ALGER), "0111111111"));
		operateur.ajouterPV(new PointDeVente("PV2", Type.PRINCIPAL, new Adresse(2, "b", "b", Wilaya.ANNABA), "0222222222"));
		operateur.ajouterPV(new PointDeVente("PV3", Type.SECONDAIRE, new Adresse(3, "c", "c", Wilaya.BEJAIA), "0333333333"));
		operateur.ajouterPV(new PointDeVente("PV4", Type.PRINCIPAL, new Adresse(4, "d", "d", Wilaya.ANNABA), "0444444444"));
		operateur.ajouterPV(new PointDeVente("PV5", Type.SECONDAIRE, new Adresse(5, "e", "e", Wilaya.ORAN), "0555555555"));
		operateur.ajouterPV(new PointDeVente("PV6", Type.PRINCIPAL, new Adresse(6, "f", "f", Wilaya.CONSTANTINE), "0666666666"));
		operateur.ajouterPV(new PointDeVente("PV7", Type.SECONDAIRE, new Adresse(7, "g", "g", Wilaya.SKIKDA), "0777777777"));
		
		Client client=new Client_Forfaitaire("0888888888", "0", "nom1", "prenom1", LocalDate.of(2022, 4, 7), new Adresse(1, "a", "a", Wilaya.ALGER), "client1@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0123456789", "1", "nom2", "prenom2", LocalDate.of(2022, 5, 14), new Adresse(2, "b", "b", Wilaya.SKIKDA), "client2@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0987654321", "2", "nom3", "prenom3", LocalDate.of(2022, 3, 9), new Adresse(3, "c", "c", Wilaya.ALGER), "client3@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0222222222", "3", "nom4", "prenom4", LocalDate.of(2022, 6, 1), new Adresse(4, "d", "d", Wilaya.ANNABA), "client4@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0636363636", "4", "nom5", "prenom5", LocalDate.of(2022, 5, 1), new Adresse(5, "e", "e", Wilaya.ORAN), "client5@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0132456789", "5", "nom6", "prenom6", LocalDate.of(2022,2,25), new Adresse(6, "f", "f", Wilaya.CONSTANTINE), "client6@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0753938322", "6", "nom7", "prenom7", LocalDate.of(2022,4,30), new Adresse(7, "g", "g", Wilaya.ALGER), "client7@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0192837465", "7", "nom8", "prenom9", LocalDate.of(2022,5,24), new Adresse(8, "h", "h", Wilaya.ALGER), "client8@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0375487447", "8", "nom9", "prenom9", LocalDate.of(2022,4,01), new Adresse(9, "i", "i", Wilaya.CONSTANTINE), "client9@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0363468385", "9", "nom10", "prenom10", LocalDate.of(2022,5,02), new Adresse(10, "j", "j", Wilaya.ANNABA), "client10@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0653973473", "10", "nom11", "prenom11", LocalDate.of(2022,3,21), new Adresse(11, "k", "k", Wilaya.ORAN), "client11@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0547847478", "11", "nom12", "prenom12", LocalDate.of(2022,3,8), new Adresse(12, "l", "l", Wilaya.BEJAIA), "client12@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0473734787", "12", "nom13", "prenom13", LocalDate.of(2022,5,12), new Adresse(13,"m", "m", Wilaya.ALGER), "client13@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0987637484", "13", "nom14", "prenom14", LocalDate.of(2022,4,1), new Adresse(14, "n", "n", Wilaya.ALGER), "client14@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0344567893", "14", "nom15", "prenom15", LocalDate.of(2022,3,25), new Adresse(15, "o", "o", Wilaya.SKIKDA), "client15@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0454555559", "15", "nom16", "prenom16", LocalDate.of(2022,2,2), new Adresse(16, "p", "p", Wilaya.BEJAIA), "client16@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0545785478", "16", "nom17", "prenom17", LocalDate.of(2022,2,17), new Adresse(17, "q", "q", Wilaya.ANNABA), "client17@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0575475474", "17", "nom18", "prenom18", LocalDate.of(2022,4,12), new Adresse(18, "r", "r", Wilaya.ORAN), "client18@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0175475489", "18", "nom19", "prenom19", LocalDate.of(2022,3,29), new Adresse(19, "s", "s", Wilaya.ALGER), "client19@gmail.com");
		operateur.ajouterClient(client);
		client=new Client_Forfaitaire("0758757848", "19", "nom20", "prenom20", LocalDate.of(2022,3,12), new Adresse(20, "t", "t", Wilaya.SKIKDA), "client20@gmail.com");
		operateur.ajouterClient(client);
	}
	static Operateur operateur = new Operateur("Operateur Test");
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int choix;
		do
		{
			choix = menu();
			executionChoixMenu(choix);
		}while(choix != 6);
  
		
    

  }
}
