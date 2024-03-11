package Homework.Core.Classes;

import Homework.Core.Archetypes.Melee;

public class Rogue extends Melee  {
    public Rogue(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 10;
        this.maxStamina = 30;
        this.strength = 10;
        this.hp = this.maxHealth;
        this.stamina = this.maxStamina;
        this.initiative = 2;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a rogue", name);
    }
    @Override
    public String getInfo(){
        return "Rogue";
    }
}
