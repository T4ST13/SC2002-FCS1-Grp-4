package domain.combatant;

import domain.action.SharedAction;
import domain.action.Skill;
import domain.actionlogic.DefendLogic;
import domain.actionlogic.SkillLogic;
import domain.combatdata.CombatType;
import domain.combatdata.SkillLogicMap;

public class Player extends Combatant {

    private final SkillLogic skillLogic;

    protected Player(CombatType playerType) {
        super(playerType);
        this.addAction(new SharedAction(this, new DefendLogic()));//all playable characters can defend
        //change 'new Logic()' to getInstance()
        this.skillLogic = SkillLogicMap.getSkillLogic(playerType);
        this.addAction(new Skill(this, this.skillLogic));
    }

    public SkillLogic getSkillLogic(){
        return skillLogic;
    }
}