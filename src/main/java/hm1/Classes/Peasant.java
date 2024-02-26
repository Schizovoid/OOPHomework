package hm1.Classes;

import hm1.Archetypes.Melee;

public class Peasant extends Melee {
    public Peasant(String name) {
        super(name);
        this.maxHealth = 30;
        this.maxStamina = 20;
        this.strength = 5;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a peasant", name);
    }
}
