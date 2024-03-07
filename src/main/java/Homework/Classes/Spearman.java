package Homework.Classes;

import Homework.Archetypes.Melee;
import Homework.Concepts.CharacterAction;

public class Spearman extends Melee {
    public Spearman(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 15;
        this.maxStamina = 20;
        this.strength = 10;
        this.health = this.maxHealth;
        this.stamina = this.maxStamina;
        this.initiative = 2;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a spearman", name);
    }
}
