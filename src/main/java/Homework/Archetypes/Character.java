package Homework.Archetypes;

import Homework.Concepts.Location;
import Homework.Concepts.Teams;

public abstract class Character {
    public String getName() {
        return name;
    }

    protected String name;
    protected boolean isAlive = true;
    protected int maxHealth;
    protected int health;
    public Location location;

    public Teams team;
    public Teams getTeam() {
        return team;
    }
    public void setTeam(Teams team) {
        this.team = team;
    }
    public Character(String name, int x, int y){
        this.name = name;
        location = new Location(x, y);
    }


    public void attack (Character target){
    }

    public void rest (){
    }

    public void heal (Character target){
    }

    public void die() {
        this.isAlive = false;
        System.out.println(String.format("%s dies!", this.name));
    }

    public String toString(){
        return String.format("This is %s, they have no class yet", name);
    }
}
