package domain.entity;

import java.util.ArrayList;
import java.util.List;

public class PlayerOptions {//used to display possible combatant types for player to choose
    private static List<CombatType> playableList = new ArrayList<>();

    public static List<CombatType> getPlayableList(){
        if (playableList.isEmpty()) {
            for (CombatType combatType : CombatType.values()) {
                if (combatType.isPlayable()) {
                    playableList.add(combatType);
                }
            }
        }
        return playableList;
    }
}
