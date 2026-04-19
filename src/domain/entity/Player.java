package domain.entity;

import domain.action.SharedAction;
import domain.action.Skill;
import domain.action.logic.ActionLogicType;
import domain.action.logic.SharedActionLogic;
import domain.action.logic.SkillLogic;

public class Player extends Combatant {

    private final SkillLogic skillLogic;

    public Player(CombatType playerType) {
        super(playerType);
        this.addAction(new SharedAction(this, new SharedActionLogic(ActionLogicType.DEFEND_LOGIC)));//all playable characters can defend
        //change 'new Logic()' to getInstance()
        this.skillLogic = SkillLogicMap.getSkillLogic(playerType);
        this.addAction(new Skill(this, this.skillLogic));
    }

    public SkillLogic getSkillLogic(){
        return skillLogic;
    }
}