package Homework.Archetypes;

public abstract class Mage extends Character {
    protected int maxMana;
    protected int mana;
    protected int intelligence;

    public Mage(String name, int x, int y){
        super(name, x, y);
    }

    public void attack(Character target) {
            target.health = target.health - this.intelligence;
            this.mana = this.mana - this.intelligence;
            if (target.health <= 0) {
                target.die();
                System.out.println(String.format("%s dies!", target.name));
            }
        }

    public void rest() {
        if (this.isAlive) {
            this.mana = maxMana;
            System.out.println(String.format("%s rests!", this.name));
        } else {
            System.out.println("This character could not perform this action.");
        }
    }

    public void heal(Character target) {
        if (this.mana > 4 && this.isAlive && target.isAlive) {
            target.health = target.health + this.intelligence;
            this.mana = this.mana - this.intelligence;
        } else {
            System.out.println("This character could not perform this action.");
        }
    }
}
