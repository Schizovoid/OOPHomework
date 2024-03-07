package Homework.Archetypes;

import Homework.Concepts.CharacterAction;
import Homework.Concepts.Location;
import Homework.Concepts.Teams;

import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Character implements CharacterAction {
    public String getName() {
        return name;
    }

    protected String name;
    protected boolean isAlive = true;
    protected boolean enemyAdjacent;
    public boolean isEnemyAdjacent() {
        return enemyAdjacent;
    }
    public void setEnemyAdjacent(boolean enemyAdjacent){
        this.enemyAdjacent = enemyAdjacent;
    }


    protected int maxHealth;
    protected int health;

    public int getInitiative() {
        return initiative;
    }

    protected int initiative;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location location;
    public Teams team;
    public Teams getTeam() {
        return team;
    }
    public void setTeam(Teams team) {
        this.team = team;
    }

    public ArrayList<Character> getTargetTeam() {
        return targetTeam;
    }

    public void setTargetTeam(ArrayList<Character> targetTeam) {
        this.targetTeam = targetTeam;
    }

    ArrayList<Character> targetTeam;

    public Character(String name, int x, int y){
        this.name = name;
        location = new Location(x, y);
        this.location.setOccupant(this);
        this.location.setOccupied(true);
    }
@Override
    public void step() {
        System.out.println(String.format("%s doesn't know what to do yet.", this.getName()));
    }

    public void attack (Character target){
    }

    public void rest (){
    }

    public void heal (Character target){
    }
    public void move (Location targetLoc){
        if (targetLoc.isOccupied()) {
            System.out.println(String.format("%s could not move to this location!", this.getName()));
        } else {
            setLocation(targetLoc);
            System.out.println(String.format("%s moves to X: %d , Y: %d", this.getName(), targetLoc.getX(), targetLoc.getY()));
            targetLoc.setOccupied(true);
            targetLoc.setOccupant(this);
        }
    }

    public void die() {
        this.isAlive = false;
        System.out.println(String.format("%s dies!", this.name));
    }

    public String toString(){
        return String.format("This is %s, they have no class yet", name);
    }
}
