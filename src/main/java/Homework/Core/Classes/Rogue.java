package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Melee;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public class Rogue extends Melee  {
    public Rogue(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 10;
        this.maxStamina = 30;
        this.strength = 15;
        this.hp = this.maxHealth;
        this.stamina = this.maxStamina;
        this.initiative = 2;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, HP: %d, Stamina: %d, Dmg: %d, X: %d, Y: %d", getName(), getInfo(), getHp(), getStamina(), getStrength(), this.location.getX(), this.location.getY());
    }
    @Override
    public String getInfo(){
        return "Rogue";
    }
}
