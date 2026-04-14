package domain.others;

import domain.combatant.Combatant;
import domain.unused.Goblin;
import domain.unused.Wolf;

import java.util.ArrayList;
import java.util.List;

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


