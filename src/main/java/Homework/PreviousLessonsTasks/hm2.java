package Homework.PreviousLessonsTasks;
import Homework.Core.Archetypes.Character;
import Homework.Classes.*;
import Homework.Core.Classes.*;
import Homework.Core.Concepts.Names;
import Homework.Core.Concepts.Teams;

import java.util.ArrayList;
import java.util.Random;

public class hm2 {
    public static void main(String[] args) {
        ArrayList <Character> teamRed = new ArrayList<>();
        ArrayList <Character> teamBlue = new ArrayList<>();
        teamRed.add(generateCharacter(Teams.RED, 7, 7));
        teamRed.add(generateCharacter(Teams.RED, 3, 5));
        Sniper anton = new Sniper("Anton", 1,5);
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


    public static Character generateCharacter(Teams team, int x, int y){
        Character character;
        switch (new Random().nextInt(0,6)){
            case (0):
                character = new Arbalest(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (1):
                character = new Monk(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (2):
                character = new Peasant(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (3):
                character = new Rogue(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (4):
                character = new Sniper(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (5):
                character = new Spearman(generateName(), x,y);
                character.setTeam(team);
                return character;
            case (6):
                character = new Wizard(generateName(), x,y);
                character.setTeam(team);
                return character;
            default:
                return null;
        }

    }

    public static String generateName(){
        Names[] names = Names.values();
        return names[new Random().nextInt(names.length)].toString();
    }
}
