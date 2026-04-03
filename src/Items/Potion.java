package Items;

import domain.combatant.Combatant;

public class Potion implements Item {
	public void use(Combatant user) {
        user.heal(100);
        System.out.println(user.getName() + " used Potion (+100 HP)");
    }
}
