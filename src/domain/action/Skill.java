package domain.action;

import domain.combatant.Combatant;
import domain.TurnBasedCount;
import domain.actionlogic.SkillLogic;

import java.util.List;

public class Skill extends Action implements TurnBasedCount{
    private int remainingCd;

    /* == Constructor == */
    public Skill(Combatant user, SkillLogic skillLogic) {
        super(user, skillLogic);
        this.remainingCd = 0;
    }

    /* == Getters == */
    public int getRemainingCd() {
        return remainingCd;
    }

    /* == Status == */
    @Override
    public boolean isAvailable() {//checks whether skill can be used
        return remainingCd == 0;
    }

    public void passTurn(){//for decreasing skill cd when turn passes
        if (remainingCd > 0) {//disable negative cooldowns
            remainingCd--;
        }
    }

    public void resetCd(){
        this.remainingCd = ((SkillLogic)this.getActionLogic()).getBaseCd();
    }

    public String getUnavailableMessage(){
        return getActionLogic().getName() + " unavailable. "
                + remainingCd + " turns left until cooldown.";
    }

    public String getDisplayFormat(){
        if (isAvailable()) {
            return String.format("%s (Ready)", getName());
        }
        else{
            return String.format("%s (Cooldown: %d turns)", getName(), remainingCd);
        }
    }

    public /*List<String>*/ void use(Combatant target) {
        //List<String> messages = super.use(target);
        super.use(target);
        this.resetCd();
        //return messages;
    }
}
