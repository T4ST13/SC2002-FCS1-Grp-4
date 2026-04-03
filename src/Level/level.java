package Level;

import java.util.*;

public class level {
	private Difficulty difficulty;
    private boolean backupSpawned = false;

    public level(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getInitialEnemies() {
        switch (difficulty) {
            case EASY:
                return List.of("Goblin", "Goblin", "Goblin");

            case MEDIUM:
                return List.of("Goblin", "Wolf");

            case HARD:
                return List.of("Goblin", "Goblin");

            default:
                return List.of();
        }
    }

    public List<String> getBackupEnemies() {
        switch (difficulty) {
            case MEDIUM:
                return List.of("Wolf", "Wolf");

            case HARD:
                return List.of("Goblin", "Wolf", "Wolf");

            default:
                return List.of();
        }
    }

    public boolean shouldSpawnBackup(boolean allInitialDead) {
        if (!backupSpawned && allInitialDead) {
            backupSpawned = true;
            return true;
        }
        return false;
    }
}
