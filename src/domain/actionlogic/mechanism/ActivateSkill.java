package domain.actionlogic.mechanism;

import domain.action.Skill;
import domain.combatant.Combatant;
import domain.combatant.Player;

public class ActivateSkill implements CombatMechanism{
    @Override
    public void execute(Combatant user, Combatant target) {
        new Skill(user, ((Player) user).getSkillLogic()).use(target);
    }
}
