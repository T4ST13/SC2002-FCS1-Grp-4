package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getUserInput(int min, int max) {
        int choice = -1;
        while (true) {
            System.out.print("> Select option (" + min + "-" + max + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return choice;
    }

    public int selectClass() {
        System.out.println("\n--- SELECT YOUR CLASS ---");
        System.out.println("1. Warrior");
        System.out.println("   HP: 260 | Attack: 40 | Defense: 20 | Speed: 30");
        System.out.println("   Special Skill: Shield Bash (Stuns enemy for 2 turns)");
        System.out.println("2. Wizard");
        System.out.println("   HP: 200 | Attack: 50 | Defense: 10 | Speed: 20");
        System.out.println("   Special Skill: Arcane Blast (AoE damage, +10 ATK per kill)");
        
        return getUserInput(1, 2);
    }


    public List<Integer> selectItems() {
        System.out.println("\n--- SELECT 2 ITEMS (Duplicates allowed) ---");
        System.out.println("1. Potion      (Heals 100 HP)");
        System.out.println("2. Power Stone (Trigger special skill once without cooldown)");
        System.out.println("3. Smoke Bomb  (Enemy attacks do 0 damage for current and next turn)");
        
        List<Integer> selectedItems = new ArrayList<>();
        System.out.println("\nSelect your FIRST item:");
        selectedItems.add(getUserInput(1, 3));
        
        System.out.println("\nSelect your SECOND item:");
        selectedItems.add(getUserInput(1, 3));
        
        return selectedItems;
    }

  
    public int selectDifficulty() {
        System.out.println("\n--- ENEMY INFORMATION ---");
        System.out.println("Goblin - HP: 55 | Attack: 35 | Defense: 15 | Speed: 25");
        System.out.println("Wolf   - HP: 40 | Attack: 45 | Defense:  5 | Speed: 35");
        
        System.out.println("\n--- SELECT DIFFICULTY LEVEL ---");
        System.out.println("1. Easy   (Initial: 3 Goblins)");
        System.out.println("2. Medium (Initial: 1 Goblin, 1 Wolf | Backup: 2 Wolves)");
        System.out.println("3. Hard   (Initial: 2 Goblins | Backup: 1 Goblin, 2 Wolves)");
        
        return getUserInput(1, 3);
    }

    public void displayPlayerTurnMenu() {
        System.out.println("\n--- YOUR TURN: CHOOSE AN ACTION ---");
        System.out.println("1. Basic Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Item");
        System.out.println("4. Special Skill");
    }
    
}