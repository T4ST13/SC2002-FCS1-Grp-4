package domain.actionlogic;

import domain.combatant.Combatant;
import domain.statuseffect.SmokeBombEffect;
import domain.statuseffect.StatusEffect;

public class SmokeBombLogic extends ItemLogic {
    private static final int DURATION = 2;

    public SmokeBombLogic() {
        super("Smoke Bomb", true, true);
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.SELF;
    }

    @Override
    public void activate(Combatant user, Combatant target) {
        requirePlayerUser(user);

        // Smoke Bomb always affects the user
        user.addStatusEffect(new StatusEffect(user, new SmokeBombEffect(), DURATION));
    }
}
