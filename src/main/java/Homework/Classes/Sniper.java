package Homework.Classes;

import Homework.Archetypes.Ranged;

public class Sniper extends Ranged {
    public Sniper(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 5;
        this.maxAmmo = 10;
        this.dexterity = 10;
        this.health = this.maxHealth;
        this.ammo = this.maxAmmo;
    }
    @Override
    public void step() {

    }
@Override
    public String toString(){
        return String.format("This is %s, they are a sniper", name);
    }
}
