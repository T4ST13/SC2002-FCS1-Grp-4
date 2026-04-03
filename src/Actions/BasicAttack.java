package Actions;

import domain.combatant.Combatant;

public class BasicAttack implements action{
	private Combatant attacker;
	private Combatant target;
	
	public BasicAttack(Combatant attacker, Combatant target)
	{
		this.attacker = attacker;
        this.target = target;
	}
	public void execute() {
        int damage = Math.max(0, attacker.getAttack() - target.getDefense());
        target.takeDamage(damage);

        System.out.println(attacker.getName() + " attacks " +
                target.getName() + " for " + damage + " damage.");
    }
	
}
