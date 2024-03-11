package Homework.Core.Archetypes;

import Homework.Core.Concepts.CharacterAction;
import Homework.Core.Concepts.Location;
import Homework.Core.Concepts.Teams;

import java.util.ArrayList;

public abstract class BaseHero implements CharacterAction {
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
    protected int hp;
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


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
    protected double[] coords = {this.location.getX(), this.location.getY()};
    public double[] getCoords() {
        return this.coords;
    }

    public Location location;
    public Teams team;
    public Teams getTeam() {
        return team;
    }
    public void setTeam(Teams team) {
        this.team = team;
    }

    public ArrayList<BaseHero> getTargetTeam() {
        return targetTeam;
    }

    public void setTargetTeam(ArrayList<BaseHero> targetTeam) {
        this.targetTeam = targetTeam;
    }

    ArrayList<BaseHero> targetTeam;

    public BaseHero(String name, int x, int y){
        this.name = name;
        location = new Location(x, y);
        this.location.setOccupant(this);
        this.location.setOccupied(true);
    }
@Override
    public void step() {
        System.out.println(String.format("%s doesn't know what to do yet.", this.getName()));
    }

    public void attack (BaseHero target){
    }

    public void rest (){
    }

    public void heal (BaseHero target){
    }
    public String getInfo(){
        return "Base Hero";
    };
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
