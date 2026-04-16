package domain.levelconfig;

import domain.combatant.Combatant;
import domain.combatant.Enemy;
import domain.combatdata.CombatType;
import domain.displayable.Displayable;

import java.util.Arrays;
import java.util.List;

public enum LevelConfig implements Displayable {
    EASY(
        "Easy",
        Arrays.asList(
            Arrays.asList(
                new Enemy(CombatType.GOBLIN),
                new Enemy(CombatType.GOBLIN),
                new Enemy(CombatType.GOBLIN)
            )
        )
    ),
    MEDIUM(
        "Medium",
        Arrays.asList(
            Arrays.asList(
                new Enemy(CombatType.GOBLIN),
                new Enemy(CombatType.WOLF)
            ),
            Arrays.asList(
                new Enemy(CombatType.WOLF),
                new Enemy(CombatType.WOLF)
            )
        )
    ),
    HARD(
        "Hard",
        Arrays.asList(
            Arrays.asList(
                new Enemy(CombatType.GOBLIN),
                new Enemy(CombatType.GOBLIN)
            ),
            Arrays.asList(
                new Enemy(CombatType.GOBLIN),
                new Enemy(CombatType.WOLF),
                new Enemy(CombatType.WOLF)
            )
        )
    );

    private String difficulty;
    private List<List<Combatant>> enemyWaves;

    LevelConfig(String difficulty, List<List<Combatant>> enemyWaves){
        this.difficulty = difficulty;
        this.enemyWaves = enemyWaves;
    }

    public String getDifficultyName(){
        return difficulty;
    }
    
    public List<List<Combatant>> getEnemyWaves(){
        return enemyWaves;
    }

    public String getDisplayFormat(){
        return getDifficultyName();
    }
}
