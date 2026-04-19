package domain.action;

import domain.entity.Combatant;
import domain.util.TurnBasedCount;
import domain.action.logic.SkillLogic;

//
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

    @Override
    public void passTurn(){//for decreasing skill cd when turn passes
        if (remainingCd > 0) {//disable negative cooldowns
            remainingCd--;
        }
    }

    public void resetCd(){
        this.remainingCd = ((SkillLogic)this.getActionLogic()).getBaseCd();
    }

    @Override
    public String getUnavailableMessage(){
        return getActionLogic().getName() + " unavailable. "
                + remainingCd + " turns left until cooldown.";
    }

    @Override
    public String getDisplayFormat(){
        if (isAvailable()) {
            return String.format("%s (Ready)", getName());
        }
        else{
            return String.format("%s (Cooldown: %d turns)", getName(), remainingCd);
        }
    }

    @Override
    public void use(Combatant target) {
        super.use(target);
        this.resetCd();
    }
}
