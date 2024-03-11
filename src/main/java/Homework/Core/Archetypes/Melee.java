package Homework.Core.Archetypes;

import Homework.Core.Concepts.Location;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Melee extends Character {
    protected int strength;
    protected int stamina;
    protected int maxStamina;

    public Melee(String name, int x, int y){
        super(name, x, y);
    }

    @Override
    public void step() {
        if (this.isAlive && this.stamina >= this.strength){
            searchAdjacent(targetTeam);
            if (isEnemyAdjacent()) {
                attackAdjacent(targetTeam);
            } else {
                moveTowardTarget(searchForTarget(targetTeam));
            }
        } else if (this.isAlive & this.stamina < this.strength) {
            rest();
        }
    }

    public void attack (Character target){
            target.health = target.health - this.strength;
            this.stamina = this.stamina - this.strength;
        System.out.println(String.format("%s attacks %s for %d damage!", this.getName(), target.getName(), this.strength));
            if (target.health <= 0){
                target.die();
                System.out.println(String.format("%s dies!", target.name));
            }
    }


    protected void attackAdjacent(ArrayList<Character> targetTeam){
        ListIterator<Character> iter = targetTeam.listIterator();
        while(iter.hasNext()) {
            Character target = iter.next();
            if (target.isAlive && target.getTeam() != this.getTeam()) {
                if (target.getLocation().getX() - this.getLocation().getX() == -1 |
                        target.getLocation().getX() - this.getLocation().getX() == 1 |
                        target.getLocation().getY() - this.getLocation().getY() == -1 |
                        target.getLocation().getY() - this.getLocation().getY() == 1)
                {
                    attack(target);
                    break;
                } else if (target.getLocation().getX() - this.getLocation().getX() == -1 && target.getLocation().getY() - this.getLocation().getY() == -1) {
                    attack(target);
                    break;
                } else if (target.getLocation().getX() - this.getLocation().getX() == -1 && target.getLocation().getY() - this.getLocation().getY() == 1) {
                    attack(target);
                    break;
                } else if (target.getLocation().getX() - this.getLocation().getX() == 1 && target.getLocation().getY() - this.getLocation().getY() == -1 ) {
                    attack(target);
                    break;
                } else if (target.getLocation().getX() - this.getLocation().getX() == 1 && target.getLocation().getY() - this.getLocation().getY() == 1){
                    attack(target);
                    break;
            }
        }
        }
    }

    protected void searchAdjacent(ArrayList<Character> targetTeam){
        ListIterator<Character> iter = targetTeam.listIterator();
        while(iter.hasNext()) {
            Character target = iter.next();
            if (target.getTeam() != this.getTeam() && target.isAlive) {
                if (target.getLocation().getX() - this.getLocation().getX() == -1 | target.getLocation().getX() - this.getLocation().getX() == 1 |
                        target.getLocation().getY() - this.getLocation().getY() == -1 | target.getLocation().getY() - this.getLocation().getY() == 1) {
                    setEnemyAdjacent(true);
                }
            }
        }
    }

    protected void moveTowardTarget(Character target){
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
    protected Character searchForTarget(ArrayList<Character> targetTeam){
        Character target = targetTeam.get(0);
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
