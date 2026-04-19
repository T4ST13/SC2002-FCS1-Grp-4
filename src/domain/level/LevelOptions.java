package domain.level;

import java.util.ArrayList;
import java.util.List;

public class LevelOptions {//list used to display avaialble levels for player to choose
    private static List<LevelConfig> levelOptions = new ArrayList<>();

    public static List<LevelConfig> getLevelOptions(){
        if (levelOptions.isEmpty()){
            for (LevelConfig levelConfig : LevelConfig.values()){
                levelOptions.add(levelConfig);
            }
        }
        return levelOptions;
    }
}
