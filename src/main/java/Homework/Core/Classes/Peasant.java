package Homework.Core.Classes;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Archetypes.Melee;
import Homework.Core.Archetypes.Ranged;
import Homework.Core.Concepts.Location;

import java.util.ArrayList;
import java.util.Objects;

public class Peasant extends BaseHero  {
    public Peasant(String name, Location loc, ArrayList<BaseHero> heroTeam, ArrayList<BaseHero> targetTeam){
        super(name, loc, heroTeam, targetTeam);
        this.maxHealth = 10;
        this.hp = this.maxHealth;
        this.initiative = 0;
    }

    @Override
    public void step(){
        if (this.isAlive){
            if (allyAdjacent(searchForTarget(getRangedAllies(getHeroTeam())))) {
                fetchArrows(searchForTarget(getRangedAllies(getHeroTeam())));
            } else {
                moveTowardTarget(searchForTarget(getRangedAllies(getHeroTeam())));
            }
        }
    }

    public void fetchArrows (Ranged ally){
        ally.setAmmo(ally.getAmmo() + 1);
        System.out.println(String.format("%s resupplies %s!", this.getName(), ally.getName()));
    }

    protected boolean allyAdjacent(Ranged ally){
        if (ally.getLocation().getX() - this.getLocation().getX() == Math.abs(1) |
                ally.getLocation().getY() - this.getLocation().getY() == Math.abs(1)) {
            return true;
        } else return false;
    }
    protected void moveTowardTarget(BaseHero target){
        if (Math.abs(target.getLocation().getX() - this.location.getX()) > Math.abs(target.getLocation().getY() - this.location.getY())){
            if (this.location.getX() > target.getLocation().getX()) {
                this.move(new Location(this.location.getX() -1, this.getLocation().getY()));
            } else if (this.location.getX() < target.getLocation().getX()) {
                this.move(new Location(this.location.getX() + 1, this.getLocation().getY()));
            }
        } else if (Math.abs(target.getLocation().getX() - this.location.getX()) < Math.abs(target.getLocation().getY() - this.location.getY())) {
            if (this.location.getY() > target.getLocation().getY()) {
                this.move(new Location(this.location.getX(), this.getLocation().getY() - 1));
            } else if (this.location.getY() < target.getLocation().getY()) {
                this.move(new Location(this.location.getX(), this.getLocation().getY() + 1));
            }
        }
    }
    public Ranged searchForTarget(ArrayList<Ranged> heroTeam){
        Ranged target = heroTeam.get(0);
        double nearest = 100;
        for (Ranged human : heroTeam) {
            if (human.isAlive() && human.getAmmo() < human.getMaxAmmo() & this.location.calculateDistance(human.location) <= nearest) {
                nearest = this.location.calculateDistance(human.location);
                target = human;
            }
        }
        return target;
    }

    public ArrayList <Ranged> getRangedAllies (ArrayList <BaseHero> heroTeam){
        ArrayList<Ranged> rangedAllies = new ArrayList<>();
        for (BaseHero human : heroTeam){
            if(Objects.equals(human.getInfo(), "Arbalest") | Objects.equals(human.getInfo(), "Bowman")){
                rangedAllies.add((Ranged) human);
            }
        }
        return rangedAllies;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, HP: %d, X: %d, Y: %d", getName(), getInfo(), getHp(), this.location.getX(), this.location.getY());
    }
    @Override
    public String getInfo(){
        return "Peasant";
    }
}
