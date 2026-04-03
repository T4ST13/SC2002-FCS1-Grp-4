package Actions;

import domain.combatant.Combatant;
import effects.StunEffect;

public class ShieldBash implements action {
	private Combatant user;
    private Combatant target;

    public ShieldBash(Combatant user, Combatant target) {
        this.user = user;
        this.target = target;
    }
    
    public void execute() {
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        target.takeDamage(damage);

        target.addStatusEffect(new StunEffect(2));

        System.out.println(user.getName() + " used Shield Bash on " +
                target.getName() + " (STUN applied)");
    }
}
