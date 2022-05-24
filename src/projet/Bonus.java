package projet;

import java.time.LocalDate;


public class Bonus
{
    enum Type {SMS, HEURES, SOLDE};

    private Type type;
    /*
     * Nombre de SMS, Nombre d heure, solde
     * a interpreter selon le type du bonus
     */
    private int bonus;
    private LocalDate dateLimite;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Bonus()
    {
    }

    public Bonus(Type type, int bonus, LocalDate dateLimite)
    {
        this.type = type;
        this.bonus = bonus;
        this.dateLimite = dateLimite;
    }

 
}
