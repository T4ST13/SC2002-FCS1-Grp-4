package Effects;

import domain.combatant.Combatant;

public class DefendEffect implements StatusEffect{
	private int turns;

    public DefendEffect(int turns) {
        this.turns = turns;
    }

    public void onTurnStart(Combatant target) {
        turns--;
    }

    public int getBonusDefense() {
        return 10;
    }

    public boolean isExpired() {
        return turns <= 0;
    }
}
