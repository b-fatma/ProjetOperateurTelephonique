package projet;

import java.util.Scanner;

public class Adresse
{
    public enum Wilaya
    {
        ALGER, ANNABA, ORAN, SKIKDA, BEJAIA, CONSTANTINE;
        static boolean wilayaValide(String input)
        {
            for(Wilaya w: Wilaya.values())
            {
                if(w.toString().equals(input.toUpperCase()))
                    return true;
            }
            return false;
        }

        static Wilaya saisirWilaya()
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Wilaya: ");
            String input = scan.next();
            while(!Wilaya.wilayaValide(input))
            {
                System.out.print("Saisissez une wilaya valide: ");
                input = scan.next();
            }
            return Wilaya.valueOf(input.toUpperCase());
        }
    }

    private int CP;
    private String nomRue, ville;
    private Wilaya wilaya;

    public Adresse(){}

    public Adresse(int CP, String nomRue, String ville, Wilaya wilaya)
    {
        this.CP = CP;
        this.nomRue = nomRue;
        this.ville = ville;
        this.wilaya = wilaya;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    @Override
    public String toString()
    {
        return ("Adresse: " + CP + "\t" + nomRue + "\t" + ville + "\t" + wilaya);
    }

    public void modifier()
    {
        System.out.println("Modification de l'adresse: ");
        Scanner scan = new Scanner(System.in);

        System.out.print("Le code postal: ");
        CP = scan.nextInt();
        scan.nextLine();

        System.out.print("Nom de la rue: ");
        nomRue = scan.nextLine();

        System.out.print("La ville: ");
        ville = scan.next();

        wilaya = Wilaya.saisirWilaya();
    }

    public static Adresse saisir()
    {
        Adresse a = new Adresse();
        Scanner scan = new Scanner(System.in);

        System.out.print("Le code postal: ");
        a.CP = scan.nextInt();
        scan.nextLine();

        System.out.print("Nom de la rue: ");
        a.nomRue = scan.nextLine();

        System.out.print("La ville: ");
        a.ville = scan.next();

        a.wilaya = Wilaya.saisirWilaya();
        return a;
    }
    
    public boolean egale(Adresse a)
    {
    	return(CP == a.CP
    			&& nomRue.equalsIgnoreCase(a.getNomRue())
    			&& ville.equalsIgnoreCase(a.getVille())
    			&& wilaya.equals(a.getWilaya()));			
    }

}
