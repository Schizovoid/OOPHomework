package hm1.Classes;

import hm1.Archetypes.Mage;

public class Wizard extends Mage {

    public Wizard(String name) {
        super(name);
        this.maxHealth = 10;
        this.maxMana = 20;
        this.intelligence = 10;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a wizard", name);
    }
}
