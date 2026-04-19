package domain.entity;

import domain.action.logic.ActionLogicType;
import domain.action.logic.SkillLogic;

import java.util.HashMap;
import java.util.Map;

//maps skills to a combatant type
public class SkillLogicMap {

    private static final Map<CombatType, SkillLogic> SKILL_LOGIC_MAP = new HashMap<>();

    static{
        SKILL_LOGIC_MAP.put(CombatType.WARRIOR, new SkillLogic(ActionLogicType.SHELD_BASH_LOGIC));
        SKILL_LOGIC_MAP.put(CombatType.WIZARD, new SkillLogic(ActionLogicType.ARCANE_BLAST_LOGIC));
    }

    public static SkillLogic getSkillLogic(CombatType combatType){
        return SKILL_LOGIC_MAP.get(combatType);
    }
}
