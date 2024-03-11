package Homework.Core.Archetypes;

public abstract class Mage extends BaseHero {
    protected int maxMana;
    protected int mana;
    protected int intelligence;

    public Mage(String name, int x, int y){
        super(name, x, y);
    }

    @Override
    public void step() {

    }
    public void attack(BaseHero target) {
            target.hp = target.hp - this.intelligence;
            this.mana = this.mana - this.intelligence;
            if (target.hp <= 0) {
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

    public void heal(BaseHero target) {
        if (this.mana > 4 && this.isAlive && target.isAlive) {
            target.hp = target.hp + this.intelligence;
            this.mana = this.mana - this.intelligence;
        } else {
            System.out.println("This character could not perform this action.");
        }
    }
}
