package Homework.Core.Archetypes;

import Homework.Core.Concepts.Location;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Melee extends BaseHero {
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    protected int strength;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    protected int stamina;
    protected int maxStamina;

    public Melee(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);}

    @Override
    public void step() {
        if (this.isAlive && this.stamina >= this.strength){
            searchAdjacent(searchForTarget(targetTeam));
            if (isEnemyAdjacent()) {
                attack(searchForTarget(targetTeam));
            } else {
                moveTowardTarget(searchForTarget(targetTeam));
            }
        } else if (this.isAlive & this.stamina < this.strength) {
            rest();
        }
    }

    public void attack (BaseHero target){
            target.hp = target.hp - this.strength;
            this.stamina = this.stamina - this.strength;
        System.out.println(String.format("%s attacks %s for %d damage!", this.getName(), target.getName(), this.strength));
            if (target.hp <= 0){
                target.die();
                System.out.println(String.format("%s dies!", target.name));
            }
    }


    protected void searchAdjacent(BaseHero target){
            if (target.isAlive && target.getHeroTeam() != this.getHeroTeam()) {
                if (target.getLocation().getX() - this.getLocation().getX() == -1 | target.getLocation().getX() - this.getLocation().getX() == 1 |
                        target.getLocation().getY() - this.getLocation().getY() == -1 | target.getLocation().getY() - this.getLocation().getY() == 1) {
                    setEnemyAdjacent(true);
                }
            }
        }

    protected void moveTowardTarget(BaseHero target){
    if (Math.abs(target.getLocation().getX() - this.location.getX()) < Math.abs(target.getLocation().getY() - this.location.getY())){
        if (this.location.getX() > target.getLocation().getX()) {
            this.move(new Location(this.location.getX() -1, this.getLocation().getY()));
        } else if (this.location.getX() < target.getLocation().getX()) {
            this.move(new Location(this.location.getX() + 1, this.getLocation().getY()));
        }
    } else if (Math.abs(target.getLocation().getX() - this.location.getX()) > Math.abs(target.getLocation().getY() - this.location.getY())) {
        if (this.location.getY() > target.getLocation().getY()) {
            this.move(new Location(this.location.getX(), this.getLocation().getY() - 1));
        } else if (this.location.getY() < target.getLocation().getY()) {
            this.move(new Location(this.location.getX(), this.getLocation().getY() + 1));
        }
    }
    }
    protected BaseHero searchForTarget(ArrayList<BaseHero> targetTeam){
        BaseHero target = targetTeam.get(0);
        double nearest = 100;
        for (int i = 0; i < targetTeam.size(); i++) {
            if (this.location.calculateDistance(targetTeam.get(i).location) <= nearest & targetTeam.get(i).isAlive){
                nearest = this.location.calculateDistance(targetTeam.get(i).location);
                target = targetTeam.get(i);
            }
        }
        return target;
    }

    public void rest() {
        if (this.isAlive) {
            this.stamina = maxStamina;
            System.out.println(String.format("%s rests!", this.name));
        } else {
            System.out.println("This character could not perform this action.");
        }
    }
}
