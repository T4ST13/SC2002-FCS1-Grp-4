package domain.battleengine;

import domain.UI.UI;
import domain.action.Action;
import domain.combatant.Combatant;
import domain.phase.Phase;
import domain.phase.PhaseFlow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BattleEngine {
    private UI mainUI = new UI();

    private final int roundSpd;

    private Combatant player;
    private List<Combatant> enemyList = new ArrayList<>();
    private List<List<Combatant>> enemyWaves;
    private List<Combatant> charOrder = new ArrayList<>();

    private boolean turnDone = false;

    private PhaseFlow phaseFlow;
    private Phase currentPhase;

    private Action currentAction;
    private Combatant currentTarget;

    private static List<String> battleLog = new ArrayList<>();

    public BattleEngine(int roundSpd, Combatant player, List<List<Combatant>> enemyWaves) {
        mainUI.displayMessage("Battle Started");

        this.roundSpd = roundSpd;

        this.player = player;
        this.enemyWaves = enemyWaves;

        this.charOrder.add(this.player);

        this.phaseFlow = new PhaseFlow(this);
    }

    public void run(){
        while (!battleDone()) {
            battleLog.clear();
            if (enemyList.isEmpty()) {
                loadWave();
            }
            sortCharOrder();
            advancePhase();
            if (currentPhase.canEnter()) {
                while(!currentPhase.isDone()) {
                    currentPhase.execute();
                }
            }
            mainUI.displayMessage(battleLog);
        }
        mainUI.displayMessage("Battle Over");
    }

    public Combatant getPlayer(){
        return player;
    }

    public void act(int actionIndex, Combatant target){
        charInTurn().useAction(actionIndex, target);
    }

    public Combatant charInTurn(){
        return charOrder.get(0);
    }

    private void sortCharOrder(){
        Collections.sort(charOrder);
//        for (Combatant combatant : charOrder){
//            System.out.println(combatant.getName() + ":" + combatant.getActionMeter());
//        }
    }

    public boolean isPlayerTurn(){
        return charInTurn() == player;
    }

    public boolean battleDone() {
        if (!player.isAlive()) {
            return true;
        }
        if (enemyList.isEmpty() && enemyWaves.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Combatant> getEnemyList(){
        return enemyList;
    }

    public List<Combatant> getCharOrder(){
        return charOrder;
    }

    private void loadWave(){
        enemyList = new ArrayList<>(enemyWaves.getFirst());
        mainUI.displayMessage("New Wave");
        charOrder.addAll(enemyList);//add all new combatants to charOrder
        enemyWaves.removeFirst();
    }

    public boolean isTurnDone(){
        return turnDone;
    }

    public void setTurnDone(boolean state){
        turnDone = state;
    }

    private void advancePhase(){
        currentPhase = phaseFlow.getNext();
    }

    public UI getUI(){
        return mainUI;
    }

    public void setCurrentAction(Action action){
        currentAction = action;
    }

    public Action getCurrentAction(){
        return currentAction;
    }

    public void setCurrentTarget(Combatant target){
        currentTarget = target;
    }

    public Combatant getCurrentTarget(){
        return currentTarget;
    }

    public static void logAction(String message){
        battleLog.add(message);
    }

}
