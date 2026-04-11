package domain.action;

import domain.TurnBasedCount;
import domain.actionlogic.SkillLogic;
import domain.combatant.Player;

public class Skill extends Action implements TurnBasedCount {
    private int remainingCd;

    /* == Constructor == */
    public Skill(Player user, SkillLogic skillLogic) {//should we change Player user to Character user for expansiveness? (ex. enemy can also use skills)
        super(user, skillLogic);
        this.remainingCd = skillLogic.getBaseCooldown();
    }

    /* == Getters == */
    public int getRemainingCd() {
        return remainingCd;
    }

    /* == Setters == */
    public void passTurn(){//for decreasing skill cd when turn passes
        if (remainingCd > 0) {//disable negative cooldowns
            remainingCd--;
        }
    }

    /* == Status == */
    @Override
    public boolean isAvailable() {//checks whether skill can be used
        return remainingCd == 0;
    }

    /* == Use == */
}
