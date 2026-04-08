package domain.combatant;

public abstract class Enemy extends Combatant {
    /* == Constructor for enemy classes == */
    protected Enemy (String name, int maxHP, int baseAttack, int baseDefense, int speed) {
            super(name, maxHP, baseAttack, baseDefense, speed);
    }

    @Override
    public final boolean isPlayerControlled() {
        return false;
    }
}
