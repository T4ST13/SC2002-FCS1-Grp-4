package domain.actionlogic;

import java.util.List;
import domain.combatant.Combatant;
import domain.combatant.Player;
import domain.combatant.Wizard;

public class ArcaneBlastLogic extends SkillLogic {
    private static final int BASE_COOLDOWN = 3;
    private static final int KILL_BONUS_ATK = 10;

    private final List<Combatant> enemyTargets;

    public ArcaneBlastLogic(List<Combatant> enemyTargets) {
        super("Arcane Blast", false, true, BASE_COOLDOWN);
        this.enemyTargets = enemyTargets;
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.AOE;
    } 

    @Override
    public void activate(Combatant user, Combatant target) {
        Player player = requirePlayerUser(user);

        if (!(user instanceof Wizard)) {
            throw new IllegalArgumentException("Arcane Blast can only be used by Wizard.");
        }

        if (enemyTargets == null || enemyTargets.isEmpty()) {
            throw new IllegalStateException("Arcane Blast requires a list of enemy targets.");
        }

        for (Combatant enemy : enemyTargets) {
            if (enemy != null && enemy.isAlive()) {
                int damage = user.calcDamage(enemy);
                enemy.takeDamage(damage);

                if (!enemy.isAlive()) {
                    user.addAttackModifier(KILL_BONUS_ATK);
                }
            }
        }

        player.startSpecialSkillCooldown();
    }
}
