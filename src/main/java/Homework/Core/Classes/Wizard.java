package Homework.Core.Classes;

import Homework.Core.Archetypes.Mage;

public class Wizard extends Mage  {

    public Wizard(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 10;
        this.maxMana = 20;
        this.intelligence = 10;
        this.hp = this.maxHealth;
        this.mana = this.maxMana;
        this.initiative = 1;
    }

    @Override
    public String toString(){
        return String.format("This is %s, they are a wizard", name);
    }
    @Override
    public String getInfo(){
        return "Wizard";
    }
}
