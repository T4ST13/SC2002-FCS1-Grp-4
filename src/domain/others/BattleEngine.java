package domain.others;

import domain.combatant.Combatant;

import java.util.Collections;
import java.util.List;

public class BattleEngine {
    private final int roundSpd;
    private final int level;
    private boolean battleDone;
    private List<Combatant> charOrder;
    private Combatant player;
    //private List<List<Combatant>> enemyWave;
    private List<Combatant> enemyWave;


    protected BattleEngine(int roundSpd, int level, Combatant player, List<Combatant> enemyWave){
        this.roundSpd = roundSpd;
        this.level = level;
        this.battleDone = false;
        this.player = player;
        this.enemyWave = enemyWave;
    }

    public boolean isBattleDone(){
        return !player.isAlive() || ;
    }

    public void act(int actionIndex, Combatant target){
        this.charInTurn().takeAction(actionIndex, target);
    }

    public Combatant charInTurn(){
        return this.charOrder.get(0);
    }

    public void sortCharOrder(){
        Collections.sort(charOrder);
    }

    public boolean isPlayerTurn(){
        return this.charInTurn() == player;
    }

}
