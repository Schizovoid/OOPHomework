package Homework.PreviousLessonsTasks;
import Homework.Core.Archetypes.BaseHero;
import Homework.Classes.*;
import Homework.Core.Classes.*;
import Homework.Core.Concepts.Names;
import Homework.Core.Concepts.Teams;

import java.util.ArrayList;
import java.util.Random;

public class hm2 {
    public static void main(String[] args) {
        ArrayList <BaseHero> teamRed = new ArrayList<>();
        ArrayList <BaseHero> teamBlue = new ArrayList<>();
        teamRed.add(generateCharacter(Teams.GREEN, 7, 7));
        teamRed.add(generateCharacter(Teams.GREEN, 3, 5));
        Bowman anton = new Bowman("Anton", 1,5);
        teamBlue.add(anton);
        anton.attackNearest(teamRed);
        anton.attackNearest(teamRed);
        anton.attackNearest(teamRed);
        anton.attackNearest(teamRed);
        anton.attackNearest(teamRed);

        System.out.println(teamRed.get(0).toString());
        System.out.println(teamRed.get(1).toString());
        System.out.println(teamBlue.get(0).toString());


    }


    public static BaseHero generateCharacter(Teams team, int x, int y){
        BaseHero baseHero;
        switch (new Random().nextInt(0,6)){
            case (0):
                baseHero = new Arbalest(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (1):
                baseHero = new Monk(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (2):
                baseHero = new Peasant(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (3):
                baseHero = new Rogue(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (4):
                baseHero = new Bowman(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (5):
                baseHero = new Spearman(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            case (6):
                baseHero = new Wizard(generateName(), x,y);
                baseHero.setTeam(team);
                return baseHero;
            default:
                return null;
        }

    }

    public static String generateName(){
        Names[] names = Names.values();
        return names[new Random().nextInt(names.length)].toString();
    }
}
