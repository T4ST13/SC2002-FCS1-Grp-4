package domain.combatant;

import domain.TurnBasedCount;
import domain.action.Action;
import domain.actionlogic.BasicAttackLogic;
import domain.statuseffect.StatusEffect;
import domain.CombatStat;

import java.util.*;

// Shared by both Player & Enemy
public abstract class Combatant implements Comparable<Combatant>{
    private final String name;
    private final HashMap<CombatStat, Integer> baseStats = new HashMap<CombatStat, Integer>();//HashMap doesn't accept primitive types (int -> Integer)
    private int currentHP;
    private boolean active;//default = true, false if stunned. reset to true every turn and check again for stun
    private boolean invulnerable;//default = false, true if used smoke bomb. reset to false every turn
    private List<StatusEffect> statusList;
    private List<Action> actionList;
    private int actionMeter;

    /* == Constructor for combatant == */
    protected Combatant (String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        this.name = name;
        baseStats.put(CombatStat.HP, baseHP);
        baseStats.put(CombatStat.ATK, baseAtk);
        baseStats.put(CombatStat.DEF, baseDef);
        baseStats.put(CombatStat.SPD, baseSpd);
        this.currentHP = baseHP; // Starts at max HP
        this.active = true;
        this.invulnerable = false;
        this.statusList = new ArrayList<>();
        this.actionList = new ArrayList<>();
        this.actionList.add(new Action(this, new BasicAttackLogic()));//all subclasses of combatants can use basic attack
        this.actionMeter = 0;
    }
    
    /* == Useful Checks == */
    public String getName() {
        return name;
    }

    /* == Getter == */
    public int getStat(CombatStat stat){
        int finalStat = baseStats.get(stat);
        for (StatusEffect effect : statusList){
            if (effect.getEffectLogic().getRelatedStat() == stat){
                finalStat += effect.getEffectLogic().getStatChange();
            }
        }
        return finalStat;
    }

    public List<Action> getActionList(){
        return this.actionList;
    }

    public int getActionMeter(){
        return this.actionMeter;
    }

    public boolean canAct(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean isInvulnerable(){
        return this.invulnerable;
    }

    public void setInvulnerable(boolean invulnerable){
        this.invulnerable = invulnerable;
    }

    /* == Status Effects == */
    public void addStatusEffect(StatusEffect effect) {
        this.statusList.add(effect);
    }

    public void activateAllEffects() {
        for (StatusEffect effect : this.statusList){
            effect.trigger(this);
        }
    }

    public void finishTurn(){
        int i = 0;
        while (i < this.statusList.size()){
            this.statusList.get(i).passTurn();
            if (this.statusList.get(i).getRemainingTs() == 0){
                this.statusList.remove(i);//get rid of expired status effects
                i--;
            }
            i++;
        }
        for (Action action : this.actionList){
            if (action instanceof TurnBasedCount){
                ((TurnBasedCount) action).passTurn();//update skill cooldown
            }
        }
    }

    /*  == Battle State == */
    // Check if dead or alive
    public boolean isAlive() {
        return currentHP > 0;   // if dead, will give false
    }

    // Calc Dmg Formula
    // Uses getAtk or Def to use effective stats
    public int calcDamage(Combatant target) {
        // Why max? If DEF gd enough, will take 0 dmg
        return Math.max(0, this.getStat(CombatStat.ATK) - target.getStat(CombatStat.DEF));
    }

    // Update health from taking damage
    public void takeDamage(int damage) {
        this.currentHP = Math.max(0, this.currentHP-damage);
    }

    // Healing
    public void heal(int amount) {
        this.currentHP = Math.min(this.getStat(CombatStat.HP), this.currentHP + amount);
    }

    public void takeAction(int actionIndex, Combatant target) {
        this.actionList.get(actionIndex).trigger(target);
    }

    @Override
    public int compareTo(Combatant other){
        return this.getStat(CombatStat.SPD) - other.getStat(CombatStat.SPD);
    }
}