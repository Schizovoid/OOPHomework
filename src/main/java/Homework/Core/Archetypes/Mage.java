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
        if (this.getMana() >= 2){
            checkWounded(this.getHeroTeam());
        } else {
            rest();
        }
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
            this.mana++;
            System.out.println(String.format("%s rests!", this.name));
        }
    }

    public void heal(BaseHero target) {
        if(target.getHp() + this.intelligence > target.getMaxHealth()){
            target.setHp(target.getMaxHealth());
        } else {
            target.hp = target.hp + this.intelligence;
            this.mana = this.mana - 2;
            System.out.println(String.format("%s heals %s!", this.getName(), target.getName()));
            }
        }
    public void resurrect (BaseHero target){
        this.setMana(this.getMana() - 10);
        target.setAlive(true);
        target.setHp(target.getMaxHealth());
        System.out.println(String.format("%s brings %s back to life!", this.getName(), target.getName()));
    }
    public void checkWounded (ArrayList<BaseHero> heroTeam){
        if (this.getMana() >= 10) {
            int deadAllies = 0;
            for (BaseHero human : heroTeam){
                if (!human.isAlive()){
                    deadAllies++;
                }
            }
            if (deadAllies >= 3){
                resurrect(searchForDeadAlly(this.getHeroTeam()));
            } else {
                healClosest(this.getHeroTeam());
            }
        } else {
            healClosest(this.getHeroTeam());
        }
    }

    protected void healClosest(ArrayList<BaseHero> targetTeam){
        BaseHero target = null;
        double nearest = 100;
        for (BaseHero human : targetTeam) {
            if (human.isAlive && human.getHp() < human.getMaxHealth() & this.location.calculateDistance(human.location) <= nearest){
                nearest = this.location.calculateDistance(human.location);
                target = human;
            }
        } if(target != null) {
            heal(target);
        } else {
            rest();
        }
    }
    protected BaseHero searchForDeadAlly(ArrayList<BaseHero> targetTeam){
        BaseHero target = targetTeam.get(0);
        double nearest = 100;
        for (BaseHero human : targetTeam) {
            if (!human.isAlive && this.location.calculateDistance(human.location) <= nearest) {
                nearest = this.location.calculateDistance(human.location);
                target = human;
            }
        }
        return target;
    }
}
