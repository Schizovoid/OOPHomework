package hm1.Classes;

import hm1.Archetypes.Mage;

public class Monk extends Mage {
    public Monk(String name) {
        super(name);
        this.maxHealth = 15;
        this.maxMana = 30;
        this.intelligence = 5;
    }

@Override
    public String toString(){
        return String.format("This is %s, they are a monk", name);
    }
}
