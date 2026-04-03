package Effects;

import domain.combatant.Combatant;

public class StunEffect implements StatusEffect{
	private int turns;

    public StunEffect(int turns) {
        this.turns = turns;
    }

    public void onTurnStart(Combatant target) {
        turns--;
    }

    public boolean preventsAction() {
        return true;
    }

    public boolean isExpired() {
        return turns <= 0;
    }
}
