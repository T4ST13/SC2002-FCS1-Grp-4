package main;

import ui.ConsoleUI;
import domain.action.logic.ItemLogic;
import domain.action.logic.ItemOptions;
import domain.battle.BattleEngine;
import domain.battle.OrderOptions;
import domain.battle.TurnDecider;
import domain.entity.Combatant;
import domain.entity.Player;
import domain.entity.PlayerOptions;
import domain.level.LevelConfig;
import domain.level.LevelOptions;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args){
        ConsoleUI menuUi = new ConsoleUI();
        TurnDecider turnDecider;
        LevelConfig selectedLevel;
        Combatant player;

        //choose Turn deciding method
        menuUi.displayOptions(OrderOptions.getOrderOptions());
        int choice = menuUi.getInput();
        turnDecider = OrderOptions.getOrderOptions().get(choice);

        //choose level
        menuUi.displayOptions(LevelOptions.getLevelOptions());
        choice = menuUi.getInput();
        selectedLevel = LevelOptions.getLevelOptions().get(choice);
        List<List<Combatant>> enemyWaves = new ArrayList<>(selectedLevel.getEnemyWaves());

        //choose player
        menuUi.displayOptions(PlayerOptions.getPlayableList());
        choice = menuUi.getInput();
        player = new Player(PlayerOptions.getPlayableList().get(choice));

        //choose item
        List<ItemLogic> items = ItemOptions.getItemOptions();
        for (int i = 0; i<2; i++) {
            menuUi.displayOptions(items);
            choice = menuUi.getInput();
            player.addItem(items.get(choice).getLogicType());
        }

        BattleEngine battleEngine = new BattleEngine(turnDecider, player, enemyWaves);
        battleEngine.run();
        String battleState;
        if (battleEngine.getPlayer().isAlive()){
            battleState = "Won";
        }
        else{
            battleState = "Lost";
        }
        menuUi.displayMessage("Player " + battleState);
    }
}


