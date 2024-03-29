package Homework;

import Homework.Core.Archetypes.BaseHero;
import Homework.Core.Classes.*;
import Homework.Core.Concepts.Location;
import Homework.Core.Concepts.Names;
import Homework.Viewer.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import javax.vecmath.Vector2d;

public class Main {
    public static final int units_amount = 10;
    public static ArrayList<BaseHero> greenTeam = new ArrayList<>();
    public static ArrayList<BaseHero> blueTeam = new ArrayList<>();
    public static ArrayList<BaseHero> allTeam = new ArrayList<>();
    public static ArrayList<BaseHero> winnerTeam = new ArrayList<>();

    public static void main(String[] args) {
        init();
        Scanner input = new Scanner(System.in);
        allTeam = sortTeam();
        while (true){
            View.view();
            input.nextLine();
            for (BaseHero human : allTeam){
                human.step();
            }
            if (winnerPresent(greenTeam, blueTeam)){
                break;
            }
        }
        if(winnerTeam.equals(greenTeam)){
            View.view();
            System.out.println("Green team wins!");
        } else if (winnerTeam.equals(blueTeam)) {
            View.view();
            System.out.println("Blue team wins!");
        }
    }
    private static void init(){
        for (int i = 0; i < units_amount; i++){
            int rnd = new Random().nextInt(4);
            switch (rnd) {
                case (0) :
                    greenTeam.add(new Bowman(generateName(), new Location(i+1, 10), greenTeam, blueTeam));
                    break;
                case (1) :
                    greenTeam.add(new Rogue(generateName(), new Location(i+1, 10), greenTeam, blueTeam));
                    break;
                case (2) :
                    greenTeam.add(new Wizard(generateName(), new Location(i+1, 10), greenTeam, blueTeam));
                    break;
                default: greenTeam.add(new Peasant(generateName(), new Location(i+1, 10), greenTeam, blueTeam));
            }
        }
        for (int i = 0; i < units_amount; i++){
            int rnd = new Random().nextInt(4);
            switch (rnd) {
                case (0) :
                    blueTeam.add(new Arbalest(generateName(), new Location(i+1, 1), blueTeam, greenTeam));
                    break;
                case (1) :
                    blueTeam.add(new Spearman(generateName(), new Location(i+1, 1), blueTeam, greenTeam));
                    break;
                case (2) :
                    blueTeam.add(new Monk(generateName(), new Location(i+1, 1), blueTeam, greenTeam));
                    break;
                default: blueTeam.add(new Peasant(generateName(), new Location(i+1, 1), blueTeam, greenTeam));
            }
        }

    }
    private static ArrayList<BaseHero> sortTeam(){
        ArrayList<BaseHero> list = new ArrayList<>();
        list.addAll(greenTeam);
        list.addAll(blueTeam);
        list.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.getInitiative() == o2.getInitiative()) return (int)(o1.getHp()-o2.getHp());
                else  return (int)(o1.getInitiative()-o2.getInitiative());
            }
        });
        return list;
    }
    public static String generateName(){
        Names[] names = Names.values();
        return names[new Random().nextInt(names.length)].toString();
    }

    public static boolean winnerPresent (ArrayList<BaseHero> greenTeam, ArrayList<BaseHero> blueTeam){
        boolean greenTeamAlive = false;
        boolean blueTeamAlive = false;
        for(BaseHero human: greenTeam){
            if (human.isAlive()) {
                greenTeamAlive = true;
                break;
            }
        }
        for(BaseHero human: blueTeam){
            if (human.isAlive()) {
                blueTeamAlive = true;
                break;
            }
        }
        if (!greenTeamAlive){
            winnerTeam = blueTeam;
            return true;
        }
        else if (!blueTeamAlive) {
            winnerTeam = greenTeam;
            return true;
        } else {return false;}
    }
}
