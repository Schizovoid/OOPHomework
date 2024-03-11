package Homework.PreviousLessonsTasks;

import Homework.Core.Archetypes.Character;
import Homework.Classes.*;
import Homework.Core.Classes.*;
import Homework.Core.Concepts.Names;
import Homework.Core.Concepts.Teams;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class hm3 {

    public static void main(String[] args) {
        ArrayList <Character> teamRed = new ArrayList<>();
        ArrayList <Character> teamBlue = new ArrayList<>();
        teamRed.add(generateCharacter(Teams.RED, teamBlue, 7, 7));
        teamRed.add(generateCharacter(Teams.RED, teamBlue, 8, 5));
        teamBlue.add(generateCharacter(Teams.BLUE, teamRed, 2, 5));
        teamBlue.add(generateCharacter(Teams.BLUE, teamRed, 3, 4));
        System.out.println(teamRed.get(0).toString());
        System.out.println(teamBlue.get(0).toString());
        System.out.println(teamRed.get(1).toString());
        System.out.println(teamBlue.get(1).toString());
        startTurn(teamRed, teamBlue);
    }

    public static void startTurn(ArrayList<Character> team1, ArrayList<Character> team2){
        for (int i = 3; i >= 0; i--) {
            ListIterator<Character> iter = team1.listIterator();
            ListIterator<Character> iter2 = team2.listIterator();
            while (iter.hasNext()){
                Character character = iter.next();
                if (character.getInitiative() == i){
                    character.step();
                }
            }
            while (iter2.hasNext()){
                Character character = iter2.next();
                if (character.getInitiative() == i){
                    character.step();
                }
            }
        }
    }
    public static Character generateCharacter(Teams team, ArrayList<Character> targetTeam, int x, int y) {
        Character character;
        switch (new Random().nextInt(0, 6)) {
            case (0):
                character = new Arbalest(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (1):
                character = new Monk(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (2):
                character = new Peasant(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (3):
                character = new Rogue(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (4):
                character = new Sniper(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (5):
                character = new Spearman(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            case (6):
                character = new Wizard(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
            default:
                character = new Peasant(generateName(), x, y);
                character.setTeam(team);
                character.setTargetTeam(targetTeam);
                return character;
        }
    }


    public static String generateName(){
        Names[] names = Names.values();
        return names[new Random().nextInt(names.length)].toString();
    }

}
