package Homework.PreviousLessonsTasks;

import Homework.Core.Archetypes.BaseHero;
import Homework.Classes.*;
import Homework.Core.Classes.*;
import Homework.Core.Concepts.Names;
import Homework.Core.Concepts.Teams;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class hm3 {

    public static void main(String[] args) {
        ArrayList <BaseHero> teamRed = new ArrayList<>();
        ArrayList <BaseHero> teamBlue = new ArrayList<>();
        teamRed.add(generateCharacter(Teams.GREEN, teamBlue, 7, 7));
        teamRed.add(generateCharacter(Teams.GREEN, teamBlue, 8, 5));
        teamBlue.add(generateCharacter(Teams.BLUE, teamRed, 2, 5));
        teamBlue.add(generateCharacter(Teams.BLUE, teamRed, 3, 4));
        System.out.println(teamRed.get(0).toString());
        System.out.println(teamBlue.get(0).toString());
        System.out.println(teamRed.get(1).toString());
        System.out.println(teamBlue.get(1).toString());
        startTurn(teamRed, teamBlue);
    }

    public static void startTurn(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){
        for (int i = 3; i >= 0; i--) {
            ListIterator<BaseHero> iter = team1.listIterator();
            ListIterator<BaseHero> iter2 = team2.listIterator();
            while (iter.hasNext()){
                BaseHero baseHero = iter.next();
                if (baseHero.getInitiative() == i){
                    baseHero.step();
                }
            }
            while (iter2.hasNext()){
                BaseHero baseHero = iter2.next();
                if (baseHero.getInitiative() == i){
                    baseHero.step();
                }
            }
        }
    }
    public static BaseHero generateCharacter(Teams team, ArrayList<BaseHero> targetTeam, int x, int y) {
        BaseHero baseHero;
        switch (new Random().nextInt(0, 6)) {
            case (0):
                baseHero = new Arbalest(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (1):
                baseHero = new Monk(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (2):
                baseHero = new Peasant(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (3):
                baseHero = new Rogue(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (4):
                baseHero = new Bowman(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (5):
                baseHero = new Spearman(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            case (6):
                baseHero = new Wizard(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
            default:
                baseHero = new Peasant(generateName(), x, y);
                baseHero.setTeam(team);
                baseHero.setTargetTeam(targetTeam);
                return baseHero;
        }
    }


    public static String generateName(){
        Names[] names = Names.values();
        return names[new Random().nextInt(names.length)].toString();
    }

}
