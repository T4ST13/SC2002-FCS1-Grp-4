package domain.combatant;

import domain.actionlogic.Skill;

public abstract class Player extends Combatant {
    private Skill specialSkill;

    /* == Constructor for player classes == */
    protected Player (String name, int maxHP, int baseAttack, int baseDefense, int speed) {
            super(name, maxHP, baseAttack, baseDefense, speed);
    }

    @Override
    public final boolean isPlayerControlled() {
        return true;
    }

    /* == Special Skills == */
    // Holds skill as obj
    protected void setSpecialSkill(Skill speciaSkill) {
        this.specialSkill = speciaSkill;
    }

    // Special Skills Getters
    public String getSpecialSkillName() {
        return specialSkill.getName();
    }

    public String getSpecialSkillDescription() {
        return specialSkill.getDescription();
    }

    public int getSpecialSkillCooldown() {
        return specialSkill.getRemainingCooldown();
    }

    public boolean canUseSpecial() {
        return specialSkill.canUse();
    }

    // Call at end of player's turn
    public void decreaseSkillCooldown() {
        if (specialSkill != null) {
            specialSkill.changeRemainingCooldown(-1);
        }
    }

    public void resetCooldown() {
        if (specialSkill != null) {
            specialSkill.resetCooldown();
        }
    }  
}