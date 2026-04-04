package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;

public class PowerStoneLogic extends ItemLogic {
    private final SkillLogic specialSkillLogic;

    public PowerStoneLogic(SkillLogic specialSkillLogic) {
        super("Power Stone", false, true);

        if (specialSkillLogic == null) {
            throw new IllegalArgumentException("Power Stone requires a valid special skill logic.");
        }

        this.specialSkillLogic = specialSkillLogic;
    }

    @Override
    public TargetMode getTargetMode() {
        return specialSkillLogic.getTargetMode();
    }

    @Override
    public void activate(Combatant user, Combatant target) {
        Player player = requirePlayerUser(user);

        // Validate target only when delegated skill actually needs one
        if (specialSkillLogic.getTargetMode() == TargetMode.SINGLE) {
            validateTarget(target);
        }

        int originalCooldown = player.getSpecialSkillCooldown();

        // Reuse the actual skill logic
        specialSkillLogic.activate(user, target);
    }
}
