package domain.combatant;

public abstract class Player extends Combatant {

    protected int specialSkillCooldown = 0;

    public Player(String name, int hp, int atk, int def, int spd) {
        super(name, hp, atk, def, spd);
    }

    public void startSpecialSkillCooldown() {
        specialSkillCooldown = 3;
    }

    public void decreaseSkillCooldown() {
        if (specialSkillCooldown > 0) {
            specialSkillCooldown--;
        }
    }

    public int getSpecialSkillCooldown() {
        return specialSkillCooldown;
    }

    public boolean canUseSpecial() {
        return specialSkillCooldown == 0;
    }

    public void useSpecialSkillWithoutCooldown() {
        System.out.println("Special skill triggered WITHOUT cooldown!");
    }

    public abstract String getSpecialSkillName();
    public abstract String getSpecialSkillDescription();
}