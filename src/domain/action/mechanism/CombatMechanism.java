package domain.action.mechanism;

import domain.entity.Combatant;

public interface CombatMechanism {//different battle mechanisms supported for the game
    void execute(Combatant user, Combatant target);

    //used to determine whether user should be asked for input in case the mechanism requires a target
    boolean needsTarget(Combatant user);
}
