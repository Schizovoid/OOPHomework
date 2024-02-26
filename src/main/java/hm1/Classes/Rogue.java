package hm1.Classes;

import hm1.Archetypes.Melee;

public class Rogue extends Melee {
    public Rogue(String name) {
        super(name);
        this.maxHealth = 10;
        this.maxStamina = 30;
        this.strength = 10;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a rogue", name);
    }
}
