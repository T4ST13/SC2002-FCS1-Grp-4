package Items;

import domain.combatant.Player;

public class PowerStone implements Item {
	public void use(domain.combatant.Combatant user) {
        if (user instanceof Player) {
            Player p = (Player) user;

            p.useSpecialSkillWithoutCooldown();
            System.out.println("Power Stone activated! Free special skill used.");
        }
    }
}
