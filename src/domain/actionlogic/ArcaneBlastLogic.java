package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;
import domain.combatant.Wizard;
import domain.statuseffect.ArcaneBlastEffect;
import domain.statuseffect.StatusEffect;
import java.util.List;

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
                enemy.takeDamageFrom(user, damage);

                if (!enemy.isAlive()) {
                    user.addStatusEffect(new StatusEffect(user, new ArcaneBlastEffect(KILL_BONUS_ATK), StatusEffect.PERMANENT_DURATION));
                }
            }
        }
    }
}
