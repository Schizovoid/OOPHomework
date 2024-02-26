package hm1.Classes;

import hm1.Archetypes.Ranged;

public class Arbalest extends Ranged {
    public Arbalest(String name) {
        super(name);
        this.maxHealth = 20;
        this.maxAmmo = 10;
        this.dexterity = 10;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are an arbalest", name);
    }
}
