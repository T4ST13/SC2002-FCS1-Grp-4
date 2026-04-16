package domain;

import domain.UI.UI;
import domain.actionlogic.ActionLogicType;
import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.combatant.Player;
import domain.combatdata.CombatType;
import domain.levelconfig.LevelConfig;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    public static void main(String[] args){
        UI menuUi = new UI();
        LevelConfig selectedLevel;
        Combatant player;

        //choose level
        List<LevelConfig> levels = Arrays.asList(LevelConfig.values());
        menuUi.displayOptions(levels);
        int choice = menuUi.getInput();
        selectedLevel = levels.get(choice);
        List<List<Combatant>> enemyWaves = new ArrayList<>(selectedLevel.getEnemyWaves());

        //choose player
        List<String> playable = new ArrayList<>(
            Arrays.asList(
                CombatType.WARRIOR.getName(),
                CombatType.WIZARD.getName()
            )
        );
        menuUi.displayOptions(playable);
        choice = menuUi.getInput();
        player = new Player(CombatType.values()[choice]);//change later (risky indexing)

        //choose item

        List<ActionLogicType> items = new ArrayList<>(
            Arrays.asList(
                ActionLogicType.POTION_LOGIC,
                ActionLogicType.POWER_STONE_LOGIC,
                ActionLogicType.SMOKE_BOMB_LOGIC
            )
        );
        for (int i = 0; i<2; i++) {
            menuUi.displayOptions(items);
            choice = menuUi.getInput();
            player.addItem(items.get(choice));
        }



        BattleEngine battleEngine = new BattleEngine(100, player, enemyWaves);
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


