package Homework.Classes;

import Homework.Archetypes.Melee;

public class Peasant extends Melee {
    public Peasant(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 30;
        this.maxStamina = 20;
        this.strength = 5;
        this.health = this.maxHealth;
        this.stamina = this.maxStamina;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a peasant", name);
    }
}
