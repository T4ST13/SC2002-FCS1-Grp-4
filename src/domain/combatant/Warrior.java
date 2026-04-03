package domain.combatant;

public class Warrior extends Player {

    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
    }

    @Override
    public String getSpecialSkillName() {
        return "Shield Bash";
    }

    @Override
    public String getSpecialSkillDescription() {
        return "Deal damage and stun enemy for 2 turns";
    }
}