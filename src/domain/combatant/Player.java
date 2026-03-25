package domain.combatant;

public abstract class Player extends Combatant {
    private final String specialSkillName;
    private final String specialSkillDescription;
    private int specialSkillCooldown;

    /* == Constructor for player classes == */
    protected Player (
        String name, int maxHP, int baseAttack, int baseDefense, int speed,
        String specialSkillName, String specialSkillDescription, int specialSkillCooldown) {
            super(name, maxHP, baseAttack, baseDefense, speed);
            this.specialSkillName = specialSkillName;
            this.specialSkillDescription = specialSkillDescription;
            this.specialSkillCooldown = 0;
    }

    @Override
    public final boolean isPlayerControlled() {
        return true;
    }

    /* == Get special skills info == */
    public String getSpecialSkillName() {
        return specialSkillName;
    }

    public String getSpecialSkillDescription() {
        return specialSkillDescription;
    }

    public int getSpecialSkillCooldown() {
        return specialSkillCooldown;
    }

    public boolean canUseSpecial() {
        return specialSkillCooldown == 0;
    }

    public void startSpecialSkillCooldown() {   // Use after SS used
        specialSkillCooldown = 3;               // Set cd to 3 turns
    }

    // Call below after player's turn
    public void decreaseSkillCooldown() {
        if (specialSkillCooldown > 0) {
            specialSkillCooldown--;
        }
    }

    public void resetCooldown() {
        specialSkillCooldown = 0;
    }
}