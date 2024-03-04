package Homework.Concepts;

import Homework.Archetypes.Character;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {
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

    Character occupant;

    public Location(int x, int y){
        X = x;
        Y = y;
    }

    public double calculateDistance (Location target){
        double dist = sqrt(pow(target.getX() - this.getX(), 2) + pow(target.getY() - this.getY(), 2) );
        return dist;
    }
}
