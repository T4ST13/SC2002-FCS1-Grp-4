package domain.combatant;
// test
// Shared by both Player & Enemy
public abstract class Combatant {
    private final String name;
    private final int maxHP;
    private final int baseAttack;
    private final int baseDefense;
    private final int speed;

    private int currentHP;
    private int attackModifier;
    private int defenseModifier;

    /* == Constructor for combatant == */
    protected Combatant (String name, int maxHP, int baseAttack, int baseDefense, int speed) {
        // Base Stats
        this.name = name;
        this.maxHP = maxHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.speed = speed;

        this.currentHP = maxHP; // Starts at max HP
        this.attackModifier = 0;
        this.defenseModifier = 0;
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

    /* == Get Effective Stats (Base + Temp Modifiers) */
    public int getAttack() {
        return baseAttack + attackModifier;
    }

    public int getDefense() {
        return baseDefense + defenseModifier;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getDefenseModifier() {
        return defenseModifier;
    }

    /*  == Battle State == */
    // Check if dead or alive
    public boolean isAlive() {
        return currentHP > 0;   // if dead, will give false
    }

    // Calc Dmg Formula
    public int calcDamage(Combatant target) {
        // If DEF gd enough, will take 0 dmg
        return Math.max(0, this.baseAttack - target.baseDefense); // Swap base to eff
    }

    // Update health from taking damage
    // Probably update, rn only looks at raw base damage
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

    // In future swap base atk to like effective atk (to create, so can account for modifiers (buffs))
    @Override public String toString() {
        return name + " [HP = " + currentHP + "/" + maxHP 
        + ", ATK = " + baseAttack
        + ", DEF = " + baseDefense
        + ", SPD = " + speed + "]"; 
    }
}