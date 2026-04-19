package domain.action.mechanism;

import domain.action.Skill;
import domain.battle.BattleEngine;
import domain.entity.Combatant;
import domain.entity.Player;
import domain.entity.SkillLogicMap;

public class ActivateSkill implements CombatMechanism{//activates the user's skill (used for power stone)

    @Override
    public boolean needsTarget(Combatant user){
        //since the mechanism itself activates another skill and doesn't do anything else,
        //whether it needs a target or not depends on the user's skill
        return SkillLogicMap.getSkillLogic(user.getCombatType()).needsTarget(user);
    }
    @Override
    public void execute(Combatant user, Combatant target) {
        String skillName = SkillLogicMap.getSkillLogic(user.getCombatType()).getName();
        String message = String.format("%s's skill (%s) activated", user.getName(), skillName);
        BattleEngine.logAction(message);

        //use a newly created new skill so it doesn't reset the original user's skill cooldown
        new Skill(user, ((Player) user).getSkillLogic()).use(target);
    }
}
