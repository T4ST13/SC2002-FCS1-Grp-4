package domain.combatant;

import domain.statuseffect.StatusEffect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Shared by both Player & Enemy
public abstract class Combatant {
    private final String name;
    private final int maxHP;
    private final int baseAttack;
    private final int baseDefense;
    private final int speed;

    private int currentHP;
    //private int attackModifier;
    //private int defenseModifier;
    private final List<StatusEffect> activeStatusEffects;

    /* == Constructor for combatant == */
    protected Combatant (String name, int maxHP, int baseAttack, int baseDefense, int speed) {
        // Base Stats
        this.name = name;
        this.maxHP = maxHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.speed = speed;

        this.currentHP = maxHP; // Starts at max HP
        //this.attackModifier = 0;
        //this.defenseModifier = 0;
        this.activeStatusEffects = new ArrayList<>();
    }
    
    /* == Useful Checks == */
    public abstract boolean isPlayerControlled();

    public String getName() {
        return name;
    }

    /* == Get Base Stats == */
    public int getMaxHp() {
        return maxHP;
    }

    public int getCurrentHp() {
        return currentHP;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getSpeed() {
        return speed;
    }


    /* == Get Temp Stats Modifier 
    Commented for now, swapped to status effect

    public void addAttackModifier(int amount) {
        attackModifier += amount;
    }

    public void addDefenseModifier(int amount) {
        defenseModifier += amount;
    }

    public void clearAttackModifier() {     // Reset atk boost
        attackModifier = 0;
    }

    public void clearDefenseModifier() {    // Reset def boost
        defenseModifier = 0;
    }

    public void resetStatModifiers() {      // Reset all stats gained
        attackModifier = 0;
        defenseModifier = 0;
    } */

    /* == Status Effects == */
    public void addStatusEffect(StatusEffect effect) {
        activeStatusEffects.add(effect);
    }

    public List<StatusEffect> getActiveStatusEffects() {
        return Collections.unmodifiableList(activeStatusEffects);
    }

    public void clearStatusEffects() {
        activeStatusEffects.clear();
    }

    public void onTurnStart() {
        for (StatusEffect effect : activeStatusEffects) {
            effect.onTurnStart();
        }
        removeExpiredStatusEffects();
    }

    public void onTurnEnd() {
        for (StatusEffect effect : activeStatusEffects) {
            effect.onTurnEnd();
        }
        removeExpiredStatusEffects();
    }

    private void removeExpiredStatusEffects() {
        Iterator<StatusEffect> iterator = activeStatusEffects.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().isExpired()) {
                iterator.remove();
            }
        }
    }

    public boolean canAct() {
        for (StatusEffect effect : activeStatusEffects) {
            if (effect.preventsAction()) {
                return false;
            }
        }
        return true;
    }


    /* == Get Effective Stats (Base + Status Effects) */
    private int getStatusAtkBonus() {
        int totalBonus = 0;

        for (StatusEffect effect : activeStatusEffects) {
            totalBonus += effect.getAttackBonus();
        }

        return totalBonus;
    }

    private int getStatusDefBonus() {
        int totalBonus = 0;

        for (StatusEffect effect : activeStatusEffects) {
            totalBonus += effect.getDefenseBonus();
        }

        return totalBonus;
    }

    public int getAttack() {
        return Math.max(0, baseAttack + getStatusAtkBonus());
    }

    public int getDefense() {
        return Math.max(0, baseDefense + getStatusDefBonus());
    }

    // Apply Damage
    public int applyIncomingDmgMod(Combatant attacker, int incomingDamage) {
        int modifiedDamage = incomingDamage;

        for (StatusEffect effect : activeStatusEffects) {
            modifiedDamage = effect.modifyIncomingDamage(attacker, modifiedDamage);
        }

        return Math.max(0, modifiedDamage);
    }

    public void takeDamageFrom(Combatant attacker, int damage) {
        takeDamage(applyIncomingDmgMod(attacker, damage));
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
        return Math.max(0, this.getAttack() - target.getDefense()); // Swap base to eff
    }

    // Update health from taking damage
    public void takeDamage(int damage) {
        if (damage < 0) {       // If DEF gd enough, take 0 dmg
            damage = 0;
        }

        currentHP -= damage;

        if (currentHP < 0) {    // If they die, update hp to 0
            currentHP = 0;
        }
    }

    // Healing
    public void heal(int amount) {
        if (amount < 0) {           // If heals somehow < 0, wont anyhow minus
            amount = 0;
        }

        currentHP += amount;

        if (currentHP > maxHP) {    // Prevent overheals / overcap health
            currentHP = maxHP;
        }
    }

    /* == Useful for Restarts == */
    public void resetHp() {
        currentHP = maxHP;
    }

    @Override 
    public String toString() {
        return name + " [HP = " + currentHP + "/" + maxHP 
        + ", ATK = " + getAttack()
        + ", DEF = " + getDefense()
        + ", SPD = " + speed 
        + ", canAct = " + canAct() + "]"; 
    }
}