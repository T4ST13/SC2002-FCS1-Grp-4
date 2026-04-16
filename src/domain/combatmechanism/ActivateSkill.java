package domain.combatmechanism;

import domain.action.Skill;
import domain.actionlogic.SkillLogic;
import domain.battleengine.BattleEngine;
import domain.combatant.Combatant;
import domain.combatant.Player;
import domain.combatdata.SkillLogicMap;

public class ActivateSkill implements CombatMechanism{

    @Override
    public boolean needsTarget(Combatant user){
        return SkillLogicMap.getSkillLogic(user.getCombatType()).needsTarget(user);
    }
    @Override
    public /*String*/ void execute(Combatant user, Combatant target) {
        String skillName = SkillLogicMap.getSkillLogic(user.getCombatType()).getName();
        String message = String.format("%s's skill (%s) activated", user.getName(), skillName);
        BattleEngine.logAction(message);
        new Skill(user, ((Player) user).getSkillLogic()).use(target);
        //return "";
    }
}
