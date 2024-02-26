package hm1.Archetypes;

public abstract class Melee extends Character {
    protected int strength;
    protected int stamina;
    protected int maxStamina;

    public Melee(String name) {
        super(name);
        this.stamina = maxStamina;
        this.health = maxHealth;
    }

    public void attack (Character target){
            target.health = target.health - this.strength;
            this.stamina = this.stamina - this.strength;
            if (target.health <= 0){
                target.die();
                System.out.println(String.format("%s dies!", target.name));
            }
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
