package projet;

import java.util.Scanner;

public enum Abonnement {
    FORFAITAIRE,
    LIBRE,
    PREPAYE;
    
	static boolean abonnementValide(String input)
    {
        for(Abonnement a: Abonnement.values())
        {
            if(a.toString().equals(input.toUpperCase()))
                return true;
        }
        return false;
    }

    static Abonnement saisirAbonnement()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Type d abonnement: ");
        String input = scan.next();
        while(!Abonnement.abonnementValide(input))
        {
            System.out.print("Abonnements offerts: Fofaitaire/Libre/Prepayé \n Resaisissez: ");
            input = scan.next();
        }
        return Abonnement.valueOf(input.toUpperCase());
    }
}
