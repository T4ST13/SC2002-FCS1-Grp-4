package domain.combatant;

public class Wizard extends Player {

    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
    }

    @Override
    public String getSpecialSkillName() {
        return "Arcane Blast";
    }

    @Override
    public String getSpecialSkillDescription() {
        return "Deal damage to all enemies, gain ATK on kill";
    }

    public void increaseAttack(int amount) {
        this.attack += amount;
    }
}