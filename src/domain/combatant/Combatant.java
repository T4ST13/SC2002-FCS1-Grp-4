package domain.combatant;

import domain.action.Item;
import domain.action.SharedAction;
import domain.actionlogic.ActionLogicType;
import domain.actionlogic.ItemLogic;
import domain.actionlogic.SharedActionLogic;
import domain.combatdata.CombatType;
import domain.effectlogic.Flag;
import domain.displayable.Displayable;
import domain.TurnBasedCount;
import domain.action.Action;
import domain.statuseffect.StatusEffect;
import domain.combatdata.CombatStat;
import domain.combatmechanism.Buff;

import java.util.*;

// Shared by both Player & Enemy
public abstract class Combatant implements Displayable, Comparable<Combatant> {
    private final CombatType combatType;
    private int currentHP;
    private Map<CombatStat, Integer> statMap = new HashMap();
    private List<Action> actionList = new ArrayList<>();;
    private List<StatusEffect> effectList = new ArrayList<>();;
    private Map<Flag, String> flagMap = new HashMap<>();//Map flag to name of the effect that created it
    private int actionMeter;

    /* == Constructor for combatant == */
    protected Combatant (CombatType combatType) {
        this.combatType = combatType;
        addAction(new SharedAction(this, new SharedActionLogic(ActionLogicType.BASIC_ATTACK_LOGIC)));//all subclasses of combatants can use basic attack
        //might change new Logic to getInstance
        this.currentHP = this.combatType.getBaseStat(CombatStat.HP);
        this.setupForTurn();
        this.actionMeter = this.combatType.getBaseStat(CombatStat.SPD);
    }

    public int getCurrentHP(){
        return currentHP;
    }

    public CombatType getCombatType(){
        return combatType;
    }

    public void setupForTurn(){
        for (CombatStat stat : CombatStat.values()){
            statMap.put(stat, getBaseStat(stat));
        }
        flagMap.clear();
    }

    public void addBuff(Buff buff){
        CombatStat targetStat = buff.getType();
        int currentStat = getFinalStat(targetStat);
        statMap.put(targetStat, currentStat + buff.getAmount());
    }

    public void addFlag(Flag flag, String s){
        flagMap.put(flag, s);
    }

    public String hasFlag (Flag flag){
        return flagMap.get(flag);
    }

    public String getName() {
        return combatType.getName();
    }

    public int getBaseStat(CombatStat statType){
        return combatType.getBaseStat(statType);
    }

    public int getFinalStat(CombatStat statType){
        return statMap.get(statType);
    }

    public List<Action> getActionList(){
        return actionList;
    }

    public Action getAction(int actionIndex){
        return actionList.get(actionIndex);
    }

    public int getActionMeter(){
        return actionMeter;
    }

    public void addStatusEffect(StatusEffect effect) {
        effectList.add(effect);
    }
    public void addAction(Action action) {
        actionList.add(action);
    }

    public void addItem(ActionLogicType itemLogicType){
        for (Action actionChoice : actionList){
            if (actionChoice.getActionLogic().getLogicType() == itemLogicType){
                ((Item)actionChoice).changeCount(1);
                return;
            }
        }
        actionList.add(new Item(this, new ItemLogic(itemLogicType)));
    }

    public void removeItem(Item item){
        actionList.remove(item);
    }

    public void activateEffects() {
        for (StatusEffect effect : effectList){
            effect.execute(this);
            //the effect object already holds its user/creator as its class attribute, so we only pass the target
        }
    }

    public void finishTurn(){
        int i = 0;
        while (i < effectList.size()){
            StatusEffect effect = effectList.get(i);
            effect.passTurn();
            if (effect.getRemainingTs() == 0){
                effectList.remove(i);//get rid of expired status effects
                i--;
            }
            i++;
        }
        for (Action action : actionList){
            if (action instanceof TurnBasedCount){
                ((TurnBasedCount) action).passTurn();//update skill cooldown
            }
        }
        resetActionMeter();
    }

    // Check if dead or alive
    public boolean isAlive() {
        return currentHP > 0;   // if dead, will give false
    }

    public void takeDamage(int damage) {
        currentHP = Math.max(0, currentHP-damage);
    }

    public void heal(int amount) {
        currentHP = Math.min(getBaseStat((CombatStat.HP)), currentHP + amount);
    }

    public void useAction(int actionIndex, Combatant target) {
        actionList.get(actionIndex).use(target);
    }

    @Override
    public int compareTo(Combatant other){
        return other.actionMeter - this.actionMeter;
    }

    public String getDisplayFormat(){
        return String.format("%s (%d)", getName(), currentHP);
    }

    public void updateActionMeter(){
        actionMeter += getFinalStat(CombatStat.SPD);
    }

    public void resetActionMeter(){
        actionMeter = 0;
    }
}
















//original constructor
//protected Combatant (String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
//        name = name;
//        baseStats.put(CombatStat.HP, baseHP);
//        baseStats.put(CombatStat.ATK, baseAtk);
//        baseStats.put(CombatStat.DEF, baseDef);
//        baseStats.put(CombatStat.SPD, baseSpd);
//        //organize with method
//        currentHP = baseHP; // Starts at max HP
//        active = true;
//        invulnerable = false;
//        effectList = new ArrayList<>();
//        actionList = new ArrayList<>();
//        addAction(new SharedAction(this, new BasicAttackLogic()));//all subclasses of combatants can use basic attack
//        //might change to getInstance
//        actionMeter = 0;
//    }

//original getter for stats
//public int getStat(CombatStat stat){
//    int finalStat = baseStats.get(stat);
//    for (StatusEffect effect : effectList){
//        if (effect.getEffectLogic().getRelatedStat() == stat){
//            finalStat += effect.getEffectLogic().getStatChange();
//        }
//    }
//    return finalStat;
//}