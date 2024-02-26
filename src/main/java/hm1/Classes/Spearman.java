package hm1.Classes;

import hm1.Archetypes.Melee;

public class Spearman extends Melee {
    public Spearman(String name) {
        super(name);
        this.maxHealth = 15;
        this.maxStamina = 20;
        this.strength = 10;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a spearman", name);
    }
}
