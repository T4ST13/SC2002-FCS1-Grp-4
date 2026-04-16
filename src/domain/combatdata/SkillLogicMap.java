package domain.combatdata;

import domain.actionlogic.ActionLogic;
import domain.actionlogic.ActionLogicType;
import domain.actionlogic.SkillLogic;

import java.util.HashMap;
import java.util.Map;

public class SkillLogicMap {

    private static final Map<CombatType, SkillLogic> SKILL_LOGIC_MAP = new HashMap<>();

    static{
        SKILL_LOGIC_MAP.put(CombatType.WARRIOR, new SkillLogic(ActionLogicType.SHELD_BASH_LOGIC) {
        });//change later to SkillLogic with enum as parameter
        SKILL_LOGIC_MAP.put(CombatType.WIZARD, new SkillLogic(ActionLogicType.ARCANE_BLAST_LOGIC));//change later to SkillLogic with enum as parameter
    }

    public static SkillLogic getSkillLogic(CombatType combatType){
        return SKILL_LOGIC_MAP.get(combatType);
    }
}
