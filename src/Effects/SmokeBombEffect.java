package Effects;

import domain.combatant.Combatant;

public class SmokeBombEffect implements StatusEffect {
	private int turns;

    public SmokeBombEffect(int turns) {
        this.turns = turns;
    }

    public void onTurnStart(Combatant target) {
        turns--;
    }

    public boolean nullifyDamage() {
        return true;
    }

    public boolean isExpired() {
        return turns <= 0;
    }

}
