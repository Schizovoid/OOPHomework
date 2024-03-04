package Homework.Classes;

import Homework.Archetypes.Melee;

public class Rogue extends Melee {
    public Rogue(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 10;
        this.maxStamina = 30;
        this.strength = 10;
        this.health = this.maxHealth;
        this.stamina = this.maxStamina;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a rogue", name);
    }
}
