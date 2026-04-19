package domain.battle;

import java.util.ArrayList;

public class OrderOptions {//used to display different options player can choose for turn deciding logic
    private static ArrayList<TurnDecider> orderOptions = new ArrayList<>();
    public static ArrayList<TurnDecider> getOrderOptions(){
        if (orderOptions.isEmpty()) {
            orderOptions.add(new SpdBasedOrder());
            orderOptions.add(new HpBasedOrder());
        }
        return orderOptions;
    }
}
