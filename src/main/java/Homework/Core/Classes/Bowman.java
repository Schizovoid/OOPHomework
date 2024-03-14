package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Ranged;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public class Bowman extends Ranged {
    public Bowman(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 5;
        this.maxAmmo = 5;
        this.dexterity = 10;
        this.hp = this.maxHealth;
        this.ammo = this.maxAmmo;
        this.initiative = 3;
    }

@Override
public String toString(){
    return String.format("%s, %s, HP: %d, Ammo: %d, Dmg: %d, X: %d, Y:%d", getName(), getInfo(), getHp(), getAmmo(), getDexterity(), this.location.getX(), this.location.getY());
}    @Override
    public String getInfo(){
        return "Bowman";
    }
}
