package hm1;

import hm1.Classes.*;

public class Main {
    public static void main(String[] args) {
        Peasant jack = new Peasant("Jack");
        Spearman lex = new Spearman("Lex");
        Rogue rick = new Rogue("Rick");
        Arbalest cillian = new Arbalest("Cillian");
        Monk arthur = new Monk("Arthur");
        Wizard merlin = new Wizard("Merlin");
        Sniper casey = new Sniper("Casey");

        System.out.println(jack.toString());
        System.out.println(lex.toString());
        System.out.println(rick.toString());
        System.out.println(cillian.toString());
        System.out.println(arthur.toString());
        System.out.println(merlin.toString());
        System.out.println(casey.toString());
    }
}
