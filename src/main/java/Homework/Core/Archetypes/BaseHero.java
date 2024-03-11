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

    protected double[] coords;
    public double[] getCoords() {
        return this.coords;
    }
    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    public Location location;

    public ArrayList<BaseHero> getTargetTeam() {
        return targetTeam;
    }

    public void setTargetTeam(ArrayList<BaseHero> targetTeam) {
        this.targetTeam = targetTeam;
    }

    ArrayList<BaseHero> targetTeam;

    public ArrayList<BaseHero> getHeroTeam() {
        return heroTeam;
    }

    public void setHeroTeam(ArrayList<BaseHero> heroTeam) {
        this.heroTeam = heroTeam;
    }

    ArrayList<BaseHero> heroTeam;

    public BaseHero(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        this.name = name;
        this.location = new Location(loc.getX(), loc.getY());
        this.location.setOccupant(this);
        this.location.setOccupied(true);
        this.heroTeam = heroTeam;
        this.targetTeam = targetTeam;
        this.coords = new double[]{this.location.getX(), this.location.getY()};
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
            this.setLocation(targetLoc);
            System.out.println(String.format("%s moves to X: %d , Y: %d", this.getName(), targetLoc.getX(), targetLoc.getY()));
            targetLoc.setOccupied(true);
            targetLoc.setOccupant(this);
            this.setCoords(new double[]{targetLoc.getX(), targetLoc.getY()});
        }
    }

    public void die() {
        this.isAlive = false;
        System.out.println(String.format("%s dies!", this.name));
        this.getHeroTeam().remove(this);
    }

    public String toString(){
        return String.format("This is %s, they have no class yet", name);
    }
}
