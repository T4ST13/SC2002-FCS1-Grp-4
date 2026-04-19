package domain.battle;

import domain.entity.Combatant;
import domain.entity.CombatStat;
import ui.displayable.Displayable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Character with lowest HP acts first in a round
public class HpBasedOrder implements TurnDecider, Comparator<Combatant>, Displayable {
    String name = "HP Based Order";

    public List<Combatant> getRoundOrder(List<Combatant> combatList){
        ArrayList<Combatant> copyList = new ArrayList<>(combatList);
        Collections.sort(copyList, this);
        return copyList;
    }

    @Override
    public int compare(Combatant c1, Combatant c2) {
        return c1.getFinalStat(CombatStat.HP) - c2.getFinalStat(CombatStat.HP);
    }

    public String getName(){return name;}

    public String getDisplayFormat(){
        return getName();
    }
}
