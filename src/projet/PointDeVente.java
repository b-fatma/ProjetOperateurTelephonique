package projet;

import java.util.Scanner;

public class PointDeVente
{
    public enum Type
    {
        SECONDAIRE, PRINCIPAL;

        static boolean typeValide(String input)
        {
            for(Type t: Type.values())
            {
                if(t.toString().equals(input.toUpperCase()))
                    return true;
            }
            return false;
        }

        static Type saisirType()
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Type: ");
            String input = scan.next();
            while(!Type.typeValide(input))
            {
                System.out.print("secondaire / principal ? ");
                input = scan.next();
            }
            return Type.valueOf(input.toUpperCase());
        }
    }

    private String nom, numero;
    private Adresse adresse;
    private Type type;

    public PointDeVente()
    {}

    public PointDeVente(String nom, Type type, Adresse adresse, String numero)
    {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
    }
    
    

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void saisir()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nom: ");
        nom = scan.next();

        numero = PointDeVente.saisirNum();

        type = Type.saisirType();

        adresse = Adresse.saisir();
    }
    
    public static String saisirNum()
    {
        Scanner scan = new Scanner(System.in);
        final String regex = "[^0{1}\\d+$]";
        System.out.print("Numero: ");
        String input =  scan.next();
        while(!input.matches(regex) || input.length() != 10)
        {
            System.out.print("Saisissez un numero valide: ");
            input =  scan.next();
        }
        return input;
    }

    public void modifierType()
    {
        type = Type.saisirType();
    }

    public void modifierNum()
    {
        numero = PointDeVente.saisirNum();
    }

    public void modifierAdresse()
    {
        adresse.modifier();
    }
    
    
    public boolean egale(PointDeVente p)
    {
    	return (adresse.egale(p.getAdresse())
    			&& nom.equalsIgnoreCase(p.getNom())
    			&& numero.equalsIgnoreCase(p.getNumero())
    			&& type.equals(p.getType()));
    }


}
