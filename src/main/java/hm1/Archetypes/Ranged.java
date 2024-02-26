package hm1.Archetypes;

public abstract class Ranged extends Character {
    protected int dexterity;
    protected int maxAmmo;
    protected int ammo;

    public Ranged(String name) {
        super(name);
    }

    public void attack (Character target){
            target.health = target.health - this.dexterity;
            this.ammo = this.ammo - this.dexterity;
            if (target.health <= 0){
                target.die();
                System.out.println(String.format("%s dies!", target.name));
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
