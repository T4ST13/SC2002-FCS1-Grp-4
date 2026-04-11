package domain;

import domain.ConsoleUI;
import domain.combatant.Combatant;
import domain.combatant.Goblin;
import domain.combatant.Wolf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args){
        Combatant player;
        List<Combatant> enemyWave = new ArrayList<>();
        enemyWave.add(new Wolf(), new Goblin());

        ConsoleUI ui = new ConsoleUI();
        int choice = ui.selectClass();
        if (choice==1){

        }
    }
}


