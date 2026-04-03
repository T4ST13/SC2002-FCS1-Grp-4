package Actions;

import domain.combatant.Combatant;
import effects.DefendEffect;

public class Defend implements action{
	private Combatant user;

    public Defend(Combatant user) {
        this.user = user;
    }
    
    public void execute() {
        user.addStatusEffect(new DefendEffect(2));
        System.out.println(user.getName() + " is defending (+10 DEF for 2 turns)");
    }

}
