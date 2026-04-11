package domain.combatant;

import domain.action.Action;
import domain.action.Skill;
import domain.actionlogic.DefendLogic;

public abstract class Player extends Combatant {
    protected Player(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.getActionList().add(new Action(this, new DefendLogic()));//all playable characters can defend
    }
}