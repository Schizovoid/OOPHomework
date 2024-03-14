package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Melee;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public class Peasant extends Melee  {
    public Peasant(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 30;
        this.maxStamina = 20;
        this.strength = 5;
        this.hp = this.maxHealth;
        this.stamina = this.maxStamina;
        this.initiative = 0;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, HP: %d, Stamina: %d, Dmg: %d, X: %d, Y: %d", getName(), getInfo(), getHp(), getStamina(), getStrength(), this.location.getX(), this.location.getY());
    }
    @Override
    public String getInfo(){
        return "Peasant";
    }
}
