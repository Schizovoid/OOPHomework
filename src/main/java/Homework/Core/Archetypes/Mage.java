package Homework.Core.Archetypes;

import Homework.Core.Concepts.Location;

import java.util.ArrayList;

public abstract class Mage extends BaseHero {
    protected int maxMana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    protected int mana;

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected int intelligence;

    public Mage(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);}

    @Override
    public void step() {
        System.out.println(String.format("%s does nothing yet", this.name));
    }
    public void attack(BaseHero target) {
            target.hp = target.hp - this.intelligence;
            this.mana = this.mana - this.intelligence;
            if (target.hp <= 0) {
                target.die();
                System.out.println(String.format("%s dies!", target.name));
            }
        }

    public void rest() {
        if (this.isAlive) {
            this.mana = maxMana;
            System.out.println(String.format("%s rests!", this.name));
        } else {
            System.out.println("This character could not perform this action.");
        }
    }

    public void heal(BaseHero target) {
        if (this.mana > 4 && this.isAlive && target.isAlive) {
            target.hp = target.hp + this.intelligence;
            this.mana = this.mana - this.intelligence;
        } else {
            System.out.println("This character could not perform this action.");
        }
    }
}
