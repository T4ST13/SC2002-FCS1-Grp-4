package domain.combatdata;

import domain.actionlogic.ArcaneBlastLogic;
import domain.actionlogic.ShieldBashLogic;
import domain.actionlogic.SkillLogic;
import domain.combatdata.CombatType;

import java.util.HashMap;
import java.util.Map;

public class SkillLogicMap {

    private static final Map<CombatType, SkillLogic> SKILL_LOGIC_MAP = new HashMap<>();

    static{
        SKILL_LOGIC_MAP.put(CombatType.WARRIOR, new ShieldBashLogic());//change later to SkillLogic with enum as parameter
        SKILL_LOGIC_MAP.put(CombatType.WIZARD, new ArcaneBlastLogic());//change later to SkillLogic with enum as parameter
    }

    public static SkillLogic getSkillLogic(CombatType combatType){
        return SKILL_LOGIC_MAP.get(combatType);
    }
}
