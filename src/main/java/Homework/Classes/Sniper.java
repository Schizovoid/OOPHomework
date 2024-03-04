package Homework.Classes;

import Homework.Archetypes.Ranged;
import Homework.Concepts.CharacterAction;

public class Sniper extends Ranged implements CharacterAction {
    public Sniper(String name, int x, int y){
        super(name, x, y);
        this.maxHealth = 5;
        this.maxAmmo = 10;
        this.dexterity = 10;
        this.health = this.maxHealth;
        this.ammo = this.maxAmmo;
        this.initiative = 3;
    }
    public void step() {

    }
@Override
    public String toString(){
        return String.format("This is %s, they are a sniper", name);
    }
}
