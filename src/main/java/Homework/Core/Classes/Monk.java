package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Mage;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public class Monk extends Mage  {
    public Monk(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 15;
        this.maxMana = 30;
        this.intelligence = 5;
        this.hp = this.maxHealth;
        this.mana = this.maxMana;
        this.initiative = 1;
    }

@Override
public String toString(){
    return String.format("%s, HP: %d, Mana: %d, Dmg: %d, X: %d, Y: %d", getInfo(), getHp(), getMana(), getIntelligence(), this.location.getX(), this.location.getY());
}    @Override
    public String getInfo(){
        return "Monk";
    }
}
