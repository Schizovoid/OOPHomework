package Homework.Classes;

import Homework.Archetypes.Mage;

public class Wizard extends Mage {

    public Wizard(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 10;
        this.maxMana = 20;
        this.intelligence = 10;
        this.health = this.maxHealth;
        this.mana = this.maxMana;
    }

    @Override
    public void step() {

    }
    @Override
    public String toString(){
        return String.format("This is %s, they are a wizard", name);
    }
}