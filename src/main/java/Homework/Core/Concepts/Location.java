package Homework.Core.Concepts;

import Homework.Core.Archetypes.BaseHero;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    protected boolean isOccupied;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    int X;

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    int Y;

    BaseHero occupant;
    public BaseHero getOccupant() {
        return occupant;
    }

    public void setOccupant(BaseHero occupant) {
        this.occupant = occupant;
    }


    public Location(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public double calculateDistance (Location target){
        double dist = sqrt(pow(target.getX() - this.getX(), 2) + pow(target.getY() - this.getY(), 2) );
        return dist;
    }
}
