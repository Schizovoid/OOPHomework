package Homework.Core.Archetypes;

import java.util.ArrayList;

public abstract class Ranged extends BaseHero {
    protected int dexterity;
    protected int maxAmmo;
    protected int ammo;

    public Ranged(String name, int x, int y){
        super(name, x, y);
    }

    @Override
    public void step() {
        if (this.isAlive){
            if (this.ammo > 0){
                attackNearest(this.getTargetTeam());
            } else {
                rest();
            }
        }

    }

    protected BaseHero searchForTarget(ArrayList<BaseHero> targetTeam){
        BaseHero target = targetTeam.get(0);
        double nearest = 100;
        for (int i = 0; i < targetTeam.size(); i++) {
           if (targetTeam.get(i).isAlive && this.location.calculateDistance(targetTeam.get(i).location) <= nearest){
               nearest = this.location.calculateDistance(targetTeam.get(i).location);
               target = targetTeam.get(i);
           }
        }
        return target;
    }
    public void attackNearest(ArrayList<BaseHero> targetTeam){
            BaseHero target = searchForTarget(targetTeam);
            target.hp = target.hp - this.dexterity;
            this.ammo = this.ammo - 1;
            System.out.println(String.format("%s attacks %s for %d damage!", this.getName(), target.getName(), this.dexterity));
            if (target.hp <= 0){
                target.die();
            }
    }

    public void rest() {
        if (this.isAlive) {
            this.ammo = maxAmmo;
            System.out.println(String.format("%s rests!", this.name));
        } else {
            System.out.println("This character could not perform this action.");
        }
    }
}