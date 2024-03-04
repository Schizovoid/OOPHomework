package Homework.Classes;

import Homework.Archetypes.Ranged;

public class Arbalest extends Ranged {
    public Arbalest(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 20;
        this.maxAmmo = 5;
        this.dexterity = 10;
        this.health = this.maxHealth;
        this.ammo = this.maxAmmo;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are an arbalest", name);
    }
}
