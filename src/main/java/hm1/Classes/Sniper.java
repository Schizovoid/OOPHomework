package hm1.Classes;

import hm1.Archetypes.Ranged;

public class Sniper extends Ranged {
    public Sniper(String name) {
        super(name);
        this.maxHealth = 5;
        this.maxAmmo = 30;
        this.dexterity = 10;
    }
@Override
    public String toString(){
        return String.format("This is %s, they are a sniper", name);
    }
}
