package hm1.Archetypes;

public abstract class Character {
    protected String name;
    protected boolean isAlive = true;
    protected int maxHealth;
    protected int health;


    public Character(String name){
        this.name = name;
        this.health = this.maxHealth;
    }

    public void attack (Character target){
    }

    public void rest (){
    }

    public void heal (Character target){
    }

    public void die() {
        this.isAlive = false;
    }

    public String toString(){
        return String.format("This is %s, they have no class yet", name);
    }
}
