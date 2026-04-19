package domain.battle;

import domain.entity.Combatant;
import domain.entity.CombatStat;
import domain.displayable.Displayable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//new feature
//character with highest spd acts first in a round
public class SpdBasedOrder implements TurnDecider, Comparator<Combatant>, Displayable {
    String name = "Speed Based Order";

    public List<Combatant> getRoundOrder(List<Combatant> combatList){
        ArrayList<Combatant> copyList = new ArrayList<>(combatList);
        Collections.sort(copyList, this);
        return copyList;
    }

    @Override
    public int compare(Combatant c1, Combatant c2) {
        return c2.getFinalStat(CombatStat.SPD) - c1.getFinalStat(CombatStat.SPD);
    }

    public String getName(){return name;}

    public String getDisplayFormat(){
        return getName();
    }
}
