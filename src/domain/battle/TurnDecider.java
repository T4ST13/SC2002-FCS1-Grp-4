package domain.battle;

import domain.entity.Combatant;

import java.util.List;

public interface TurnDecider {
    List<Combatant> getRoundOrder(List<Combatant> combatList);
    String getName();
}
