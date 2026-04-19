package domain.util;

//for actions that change state every turn (ex. skill cooldown, status remaining turns)
public interface TurnBasedCount {
    void passTurn();
}
