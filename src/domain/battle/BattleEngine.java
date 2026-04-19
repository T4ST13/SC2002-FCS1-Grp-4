package domain.battle;

import ui.ConsoleUI;
import domain.action.Action;
import domain.entity.Combatant;
import domain.battle.phase.Phase;
import domain.battle.phase.PhaseFlow;

import java.util.ArrayList;
import java.util.List;

public class BattleEngine {//stores and manages overall flow of the battle
    private ConsoleUI mainUI = new ConsoleUI();

    private TurnDecider turnDecider;//holds logic for deciding turn order

    private int round;

    private int charOrderIndex;//indicates which char's turn it is

    private Combatant player;
    private List<Combatant> enemyList = new ArrayList<>();
    private List<List<Combatant>> enemyWaves;
    private List<Combatant> charOrder = new ArrayList<>();

    private boolean turnDone = false;//becomes true only if used action comsumes turn (like basic attack or skill, but not items)

    private PhaseFlow phaseFlow;//stores the order of battle phases
    private Phase currentPhase;

    private Action currentAction;//action chosen by combatant currently in turn
    private Combatant currentTarget;//target chosen by combatant currently in turn

    private static List<String> battleLog = new ArrayList<>();//used to record actions/results to be displayed during battle

    public BattleEngine(TurnDecider turnDecider, Combatant player, List<List<Combatant>> enemyWaves) {
        mainUI.displayMessage("Battle Started");

        this.turnDecider = turnDecider;

        this.round = 1;
        this.charOrderIndex = 0;

        this.player = player;
        this.enemyWaves = enemyWaves;

        this.charOrder.add(this.player);


        this.phaseFlow = new PhaseFlow(this);
    }

    public void run() {
        while (!battleDone()) {
            //load wave if wave is cleared
            if (enemyList.isEmpty()) {
                loadWave();
            }

            charOrder = turnDecider.getRoundOrder(charOrder);
            mainUI.displayMessage("Round " + round);

            while (charOrderIndex < charOrder.size()) {
                // If they are dead, instantly fast-forward the index and skip
                if (!charInTurn().isAlive()) {
                    charOrderIndex++;
                    continue;
                }

                battleLog.clear();

                advancePhase();
                if (currentPhase.canEnter()) {
                    while (!currentPhase.isDone()) {
                        currentPhase.execute();
                    }
                }
                mainUI.displayMessage(battleLog);
                if (battleDone()) {
                    break;
                }
            }

            mainUI.displayMessage("Round Done");

            for (int i = charOrder.size() - 1; i >= 0; i--) {
                if (!charOrder.get(i).isAlive()) {
                    charOrder.remove(i);
                }
            }

            for (int i = enemyList.size() - 1; i >= 0; i--) {
                if (!enemyList.get(i).isAlive()) {
                    enemyList.remove(i);
                }
            }

            charOrderIndex = 0;
            round++;

            if (battleDone()) {
                mainUI.displayMessage("Battle Over");
            }
        }
    }

    public Combatant getPlayer(){
        return player;
    }

    public void act(int actionIndex, Combatant target){
        charInTurn().useAction(actionIndex, target);
    }

    public Combatant charInTurn(){
        // It now correctly points to whoever's turn it currently is!
        return charOrder.get(charOrderIndex);
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

    public ConsoleUI getUI(){
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

    public void nextChar(){
        charOrderIndex++;
    }
}
