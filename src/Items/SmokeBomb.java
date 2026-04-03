package Items;

import domain.combatant.Combatant;
import effects.SmokeBombEffect;

public class SmokeBomb implements Item{
	public void use(Combatant user) {
        user.addStatusEffect(new SmokeBombEffect(2));
        System.out.println(user.getName() + " used Smoke Bomb (immune for 2 turns)");
    }
}
