package Homework.Core.Classes;

import Homework.Core.Archetypes.Mage;

public class Monk extends Mage  {
    public Monk(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 15;
        this.maxMana = 30;
        this.intelligence = 5;
        this.hp = this.maxHealth;
        this.mana = this.maxMana;
        this.initiative = 1;
    }

@Override
    public String toString(){
        return String.format("This is %s, they are a monk", name);
    }
    @Override
    public String getInfo(){
        return "Monk";
    }
}
