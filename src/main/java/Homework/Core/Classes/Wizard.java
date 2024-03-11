package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Mage;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public class Wizard extends Mage  {

    public Wizard(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 10;
        this.maxMana = 20;
        this.intelligence = 10;
        this.hp = this.maxHealth;
        this.mana = this.maxMana;
        this.initiative = 1;
    }

    @Override
    public String toString(){
        return String.format("%s, HP: %d, Mana: %d, Dmg: %d", getInfo(), getHp(), getMana(), getIntelligence());

    }
    @Override
    public String getInfo(){
        return "Wizard";
    }
}
