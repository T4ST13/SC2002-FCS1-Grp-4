package domain.combatant;

import java.util.*;
import effects.StatusEffect;

public abstract class Combatant {

    protected String name;
    protected int currentHp;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected int speed;

    protected List<StatusEffect> statusEffects = new ArrayList<>();

    public Combatant(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.currentHp = hp;
        this.maxHp = hp;
        this.attack = atk;
        this.defense = def;
        this.speed = spd;
    }

    // ================= BASIC METHODS =================

    public void takeDamage(int dmg) {
        currentHp = Math.max(0, currentHp - dmg);
    }

    public void heal(int amount) {
        currentHp = Math.min(maxHp, currentHp + amount);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public int calcDamage(Combatant target) {
        return Math.max(0, this.attack - target.defense);
    }

    // ================= STATUS EFFECT =================

    public void addStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }

    public void processStatusEffects() {
        Iterator<StatusEffect> it = statusEffects.iterator();

        while (it.hasNext()) {
            StatusEffect e = it.next();
            e.onTurnStart(this);

            if (e.isExpired()) {
                it.remove();
            }
        }
    }

    // ================= GETTERS =================

    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }

    public boolean isPlayerControlled() {
        return this instanceof Player;
    }
}