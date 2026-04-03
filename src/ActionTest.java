// Use to test action logic, whether they can interact with combatant + skill classes

import domain.actionlogic.Action;
import domain.actionlogic.ArcaneBlastLogic;
import domain.actionlogic.BasicAttackLogic;
import domain.actionlogic.DefendLogic;
import domain.actionlogic.ShieldBashLogic;
import domain.combatant.Combatant;
import domain.combatant.Goblin;
import domain.combatant.Player;
import domain.combatant.Warrior;
import domain.combatant.Wizard;
import domain.combatant.Wolf;
import java.util.Arrays;
import java.util.List;

public class ActionTest {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" ACTION + LOGIC + COMBATANT TEST DRIVER ");
        System.out.println("========================================\n");

        testWarriorBasicAttackOnGoblin();
        testWarriorDefendAgainstWolf();
        testEnemyBasicAttackOnPlayer();
        testWizardBasicAttackOnWolf();
        testWarriorShieldBashOnGoblin();
        testWizardArcaneBlastOnAllEnemies();
        testActionMetadata();
    }

    private static void testWarriorBasicAttackOnGoblin() {
        Combatant warrior = new Warrior();
        Combatant goblin = new Goblin();
        Action basicAttack = new Action(warrior, new BasicAttackLogic());

        printSection("1) Warrior basic attacks Goblin");
        printCombatState("Before", warrior, goblin);

        int expectedDamage = warrior.calcDamage(goblin); // 40 - 15 = 25
        basicAttack.trigger(goblin);

        System.out.println("Expected damage : " + expectedDamage);
        System.out.println("Goblin HP check : " + goblin.getCurrentHp() + "/" + goblin.getMaxHp());
        printCombatState("After", warrior, goblin);
    }

    private static void testWarriorDefendAgainstWolf() {
        Combatant warrior = new Warrior();
        Combatant wolf = new Wolf();
        Action defend = new Action(warrior, new DefendLogic());
        Action wolfAttack = new Action(wolf, new BasicAttackLogic());

        printSection("2) Warrior defends, then Wolf attacks");
        printCombatState("Before", warrior, wolf);

        defend.trigger(warrior); // current design still requires a target, so pass self
        System.out.println("Warrior DEF after defend: " + warrior.getDefense());

        int expectedDamage = wolf.calcDamage(warrior); // 45 - 30 = 15 after defend
        wolfAttack.trigger(warrior);

        System.out.println("Expected wolf damage after defend: " + expectedDamage);
        System.out.println("Warrior HP check               : " + warrior.getCurrentHp() + "/" + warrior.getMaxHp());
        printCombatState("After", warrior, wolf);
    }

    private static void testEnemyBasicAttackOnPlayer() {
        Combatant goblin = new Goblin();
        Combatant warrior = new Warrior();
        Action goblinAttack = new Action(goblin, new BasicAttackLogic());

        printSection("3) Goblin basic attacks Warrior");
        printCombatState("Before", goblin, warrior);

        int expectedDamage = goblin.calcDamage(warrior); // 35 - 20 = 15
        goblinAttack.trigger(warrior);

        System.out.println("Expected damage : " + expectedDamage);
        System.out.println("Warrior HP check: " + warrior.getCurrentHp() + "/" + warrior.getMaxHp());
        printCombatState("After", goblin, warrior);
    }

    private static void testWizardBasicAttackOnWolf() {
        Combatant wizard = new Wizard();
        Combatant wolf = new Wolf();
        Action basicAttack = new Action(wizard, new BasicAttackLogic());

        printSection("4) Wizard basic attacks Wolf");
        printCombatState("Before", wizard, wolf);

        int expectedDamage = wizard.calcDamage(wolf); // 50 - 5 = 45
        basicAttack.trigger(wolf);

        System.out.println("Expected damage : " + expectedDamage);
        System.out.println("Wolf alive?     : " + wolf.isAlive());
        System.out.println("Wolf HP check   : " + wolf.getCurrentHp() + "/" + wolf.getMaxHp());
        printCombatState("After", wizard, wolf);
    }

    private static void testWarriorShieldBashOnGoblin() {
        Warrior warrior = new Warrior();
        Combatant goblin = new Goblin();
        Action shieldBash = new Action(warrior, new ShieldBashLogic());

        printSection("5) Warrior uses Shield Bash on Goblin");
        printCombatState("Before", warrior, goblin);

        int expectedDamage = warrior.calcDamage(goblin); // currently same formula as basic attack
        System.out.println("Skill available before use? : " + shieldBash.isAvailable());

        shieldBash.trigger(goblin);

        System.out.println("Expected damage             : " + expectedDamage);
        System.out.println("Goblin HP check             : " + goblin.getCurrentHp() + "/" + goblin.getMaxHp());
        System.out.println("Warrior cooldown after use  : " + warrior.getSpecialSkillCooldown());
        System.out.println("Skill available after use?  : " + shieldBash.isAvailable());
        printCombatState("After", warrior, goblin);
    }

    private static void testWizardArcaneBlastOnAllEnemies() {
        Wizard wizard = new Wizard();
        Combatant goblin = new Goblin();
        Combatant wolf = new Wolf();
        List<Combatant> enemies = Arrays.asList(goblin, wolf);
        Action arcaneBlast = new Action(wizard, new ArcaneBlastLogic(enemies));

        printSection("6) Wizard uses Arcane Blast on all enemies");
        printCombatState("Before", wizard, goblin);
        System.out.println("- " + wolf);
        System.out.println();

        int expectedGoblinDamage = wizard.calcDamage(goblin); // 50 - 15 = 35
        int expectedWolfDamage = wizard.calcDamage(wolf);     // 50 - 5 = 45

        System.out.println("Skill available before use? : " + arcaneBlast.isAvailable());

        // target is ignored by current ArcaneBlastLogic draft, but still required by Action.trigger(...)
        arcaneBlast.trigger(goblin);

        System.out.println("Expected Goblin damage      : " + expectedGoblinDamage);
        System.out.println("Expected Wolf damage        : " + expectedWolfDamage);
        System.out.println("Goblin HP check             : " + goblin.getCurrentHp() + "/" + goblin.getMaxHp());
        System.out.println("Wolf HP check               : " + wolf.getCurrentHp() + "/" + wolf.getMaxHp());
        System.out.println("Wizard ATK after kills      : " + wizard.getAttack());
        System.out.println("Wizard cooldown after use   : " + wizard.getSpecialSkillCooldown());
        System.out.println("Skill available after use?  : " + arcaneBlast.isAvailable());

        System.out.println("After state:");
        System.out.println("- " + wizard);
        System.out.println("- " + goblin);
        System.out.println("- " + wolf);
        System.out.println();
    }

    private static void testActionMetadata() {
        Combatant warrior = new Warrior();
        Combatant wizard = new Wizard();

        Action basicAttack = new Action(warrior, new BasicAttackLogic());
        Action defend = new Action(warrior, new DefendLogic());
        Action shieldBash = new Action(warrior, new ShieldBashLogic());
        Action arcaneBlast = new Action(wizard,
            new ArcaneBlastLogic(Arrays.asList(new Goblin(), new Wolf())));

        printSection("7) Action metadata checks");
        printActionInfo(basicAttack);
        printActionInfo(defend);
        printActionInfo(shieldBash);
        printActionInfo(arcaneBlast);
    }

    private static void printActionInfo(Action action) {
        System.out.println("Action name      : " + action.getName());
        System.out.println("Used by          : " + action.getUser().getName());
        System.out.println("Available        : " + action.isAvailable());
        System.out.println("Self target?     : " + action.getActionLogic().isSelfTarget());
        System.out.println("Ends turn?       : " + action.getActionLogic().isEndTurn());
        System.out.println("Target mode      : " + action.getActionLogic().getTargetMode());

        if (action.getUser() instanceof Player) {
            Player player = (Player) action.getUser();
            System.out.println("User cooldown    : " + player.getSpecialSkillCooldown());
        }

        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println("----------------------------------------");
        System.out.println(title);
        System.out.println("----------------------------------------");
    }

    private static void printCombatState(String label, Combatant first, Combatant second) {
        System.out.println(label + " state:");
        System.out.println("- " + first);
        System.out.println("- " + second);
        System.out.println();
    }
}