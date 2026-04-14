//package domain;
//
//import domain.actionlogic.*;
//
//import java.util.Map;
//import java.util.HashMap;
//
//public class LogicStorage {
//    private static final Map<ActionChoice, ActionLogic> LOGIC_MAP = new HashMap<>();
//
//    //runs once when the class is loaded
//    static {
//        LOGIC_MAP.put(ActionChoice.BASIC_ATTACK, new BasicAttackLogic());
//        LOGIC_MAP.put(ActionChoice.DEFEND, new DefendLogic());
//        LOGIC_MAP.put(ActionChoice.SMOKE_BOMB, new SmokeBombLogic());
//        LOGIC_MAP.put(ActionChoice.POTION, new PotionLogic());
//        LOGIC_MAP.put(ActionChoice.POWER_STONE, new PowerStoneLogic());
//        LOGIC_MAP.put(ActionChoice.ARCANE_BLAST, new ArcaneBlastLogic());
//        LOGIC_MAP.put(ActionChoice.SHIELD_BASH, new ShieldBashLogic());
//    }
//
//    // Static getter method
//    public static ActionLogic getLogic(ActionChoice choice) {
//        return LOGIC_MAP.get(choice);
//    }
//}
