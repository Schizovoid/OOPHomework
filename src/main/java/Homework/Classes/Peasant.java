package Homework.Classes;

import Homework.Archetypes.Melee;
import Homework.Concepts.CharacterAction;

public class Peasant extends Melee implements CharacterAction {
    public Peasant(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 30;
        this.maxStamina = 20;
        this.strength = 5;
        this.health = this.maxHealth;
        this.stamina = this.maxStamina;
        this.initiative = 0;
    }
@Override
    public void step() {

    }
    @Override
    public String toString(){
        return String.format("This is %s, they are a peasant", name);
    }
}
