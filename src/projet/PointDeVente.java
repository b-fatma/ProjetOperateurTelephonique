package projet;

import java.util.Scanner;

public class PointDeVente
{
    public enum Type
    {SECONDAIRE, PRINCIPAL;
        static boolean typeValide(String input)
        {
            for(Type t: Type.values())
            {
                if(t.toString().equals(input.toUpperCase()))
                    return true;
            }
            return false;
        }
    }

    private String nom, numero;
    private Adresse adresse;
    private Type type;

    public PointDeVente()
    {}

    public PointDeVente(String nom, Type type, Adresse adressse, String numero)
    {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
    }

    public void modifierType()
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while(!Type.typeValide(input))
        {
            System.out.print("secondaire / principal ? ");
            input = scan.next();
        }
        type = Type.valueOf(input.toUpperCase());
    }

    public void modifierNum()
    {
        Scanner scan = new Scanner(System.in);
        final String regex = "[^0{1}\\d+$]";
        String input =  scan.next();
        while(!input.matches(regex) || input.length() != 10)
        {
            System.out.print("Saisissez un numero valide: ");
            input =  scan.next();
        }
        numero = input;
    }

    public void modifierAdresse()
    {
        adresse.modifier();
    }


}
