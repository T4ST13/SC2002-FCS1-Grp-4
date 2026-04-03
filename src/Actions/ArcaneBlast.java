package Actions;

import domain.combatant.Combatant;
import java.util.List;

public class ArcaneBlast implements action {
	 private Combatant user;
	    private List<Combatant> enemies;

	    public ArcaneBlast(Combatant user, List<Combatant> enemies) {
	        this.user = user;
	        this.enemies = enemies;
	    }

	    @Override
	    public void execute() {
	        int kills = 0;

	        for (Combatant enemy : enemies) {
	            if (!enemy.isAlive()) continue;

	            int damage = Math.max(0, user.getAttack() - enemy.getDefense());
	            enemy.takeDamage(damage);

	            if (!enemy.isAlive()) {
	                kills++;
	            }
	        }

	        if (kills > 0) {
	            user.increaseAttack(10 * kills);
	        }

	        System.out.println(user.getName() + " used Arcane Blast on all enemies.");
	    }
}
