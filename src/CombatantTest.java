// Use to test combatant class & subclasses

import domain.combatant.Combatant;
import domain.combatant.Goblin;
import domain.combatant.Player;
import domain.combatant.Warrior;
import domain.combatant.Wizard;
import domain.combatant.Wolf;

public class CombatantTest {

    public static void main(String[] args) {
        // Store all concrete subclasses inside one Combatant array
        // This demonstrates polymorphism: different subclasses treated as Combatant
        Combatant[] combatants = {
            new Warrior(),
            new Wizard(),
            new Goblin(),
            new Wolf()
        };

        System.out.println("========================================");
        System.out.println("     COMBATANT HIERARCHY TEST DRIVER    ");
        System.out.println("========================================\n");

        // Print general info for every combatant
        for (Combatant c : combatants) {
            printCombatantInfo(c);
            System.out.println("----------------------------------------");
        }

        // Extra test: show polymorphic damage calculation
        System.out.println("\n=== DAMAGE CALCULATION CHECK ===");
        Combatant warrior = new Warrior();
        Combatant goblin = new Goblin();

        int damage = warrior.calcDamage(goblin);
        System.out.println(warrior.getName() + " attacks " + goblin.getName());
        System.out.println("Calculated damage = max(0, ATK - DEF)");
        System.out.println("= max(0, " + warrior.getAttack() + " - " + goblin.getDefense() + ")");
        System.out.println("= " + damage);

        goblin.takeDamage(damage);
        System.out.println(goblin.getName() + " HP after damage: " +
                goblin.getCurrentHp() + "/" + goblin.getMaxHp());

        // Extra test: healing
        System.out.println("\n=== HEAL CHECK ===");
        goblin.heal(10);
        System.out.println(goblin.getName() + " HP after heal by 10HP: " +
        goblin.getCurrentHp() + "/" + goblin.getMaxHp());

        // Extra test: player cooldown fields
        System.out.println("\n=== PLAYER SKILL COOLDOWN CHECK ===");
        Player wizard = new Wizard();
        printPlayerSkillInfo(wizard);

        wizard.startSpecialSkillCooldown();
        System.out.println("After using special skill:");
        printPlayerSkillInfo(wizard);

        wizard.decreaseSkillCooldown();
        System.out.println("After 1 turn passed:");
        printPlayerSkillInfo(wizard);

        wizard.decreaseSkillCooldown();
        wizard.decreaseSkillCooldown();
        System.out.println("After total 3 turns passed:");
        printPlayerSkillInfo(wizard);
    }

    /**
     * Prints general information for any Combatant object.
     * Uses only methods from the base class where possible.
     */
    public static void printCombatantInfo(Combatant c) {
        System.out.println("Class Type   : " + c.getClass().getSimpleName());
        System.out.println("Name         : " + c.getName());
        System.out.println("Category     : " + (c.isPlayerControlled() ? "Player" : "Enemy"));
        System.out.println("HP           : " + c.getCurrentHp() + "/" + c.getMaxHp());
        System.out.println("ATK          : " + c.getAttack());
        System.out.println("DEF          : " + c.getDefense());
        System.out.println("SPD          : " + c.getSpeed());
        System.out.println("Alive Status : " + c.isAlive());

        // Only Player objects have special skill info
        if (c instanceof Player) {
            Player p = (Player) c;
            System.out.println("Skill Name   : " + p.getSpecialSkillName());
            System.out.println("Skill Desc   : " + p.getSpecialSkillDescription());
            System.out.println("Cooldown     : " + p.getSpecialSkillCooldown());
            System.out.println("Can Use SS?  : " + p.canUseSpecial());
        }
    }

    /**
     * Print player-only special skill details.
     */
    public static void printPlayerSkillInfo(Player p) {
        System.out.println("Player       : " + p.getName());
        System.out.println("Skill        : " + p.getSpecialSkillName());
        System.out.println("Description  : " + p.getSpecialSkillDescription());
        System.out.println("Cooldown     : " + p.getSpecialSkillCooldown());
        System.out.println("Can Use SS?  : " + p.canUseSpecial());
        System.out.println();
    }
}
