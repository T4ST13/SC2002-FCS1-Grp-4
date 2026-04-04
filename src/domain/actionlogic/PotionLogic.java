package domain.actionlogic;

import domain.combatant.Combatant;

public class PotionLogic extends ItemLogic {
    private static final int HEAL_AMOUNT = 100;

    public PotionLogic() {
        super("Potion", true, true);
    }

    @Override
    public TargetMode getTargetMode() {
        return TargetMode.SELF;
    }

    @Override
    public void activate(Combatant user, Combatant target) {
        requirePlayerUser(user);

        // Potion always affects the user
        user.heal(HEAL_AMOUNT);
    }
}
