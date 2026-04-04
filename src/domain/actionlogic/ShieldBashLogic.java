package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatant.Player;
import domain.combatant.Warrior;
import domain.statuseffect.StatusEffect;
import domain.statuseffect.StunEffect;

public class ShieldBashLogic extends SkillLogic {
    private static final int BASE_COOLDOWN = 3;

    public ShieldBashLogic() {
        super("Shield Bash", false, true, BASE_COOLDOWN);
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.SINGLE;
    } 

    @Override
    public void activate(Combatant user, Combatant target) {
        Player player = requirePlayerUser(user);
        validateTarget(target);

        if (!(user instanceof Warrior)) {
            throw new IllegalArgumentException("Shield Bash can only be used by Warrior.");
        }

        int damage = user.calcDamage(target);
        target.addStatusEffect(new StatusEffect(target, new StunEffect(), STUN_DURATION));
        target.takeDamageFrom(user, damage);

        player.startSpecialSkillCooldown();

        // TO DO: Add stun logic after status effect system is implemented.
    }
}
