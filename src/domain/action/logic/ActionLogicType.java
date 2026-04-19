package domain.action.logic;

import domain.action.condition.Defeated;
import domain.action.mechanism.*;
import domain.effect.EffectLogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ActionLogicType {//holds defined mechanisms of each action logic
    //Shared Action Logic
    BASIC_ATTACK_LOGIC(
        "Basic Attack",
        Arrays.asList(
            new Damage(TargetMode.TARGET)//might take maxTarget out
        ),
        ActionType.SHARED_LOGIC
    ),
    DEFEND_LOGIC(
        "Defend",
        Arrays.asList(
            new ApplyEffect(TargetMode.SELF, EffectLogic.DEFEND_EFFECT)
        ),
        ActionType.SHARED_LOGIC
    ),

    //Item Logic
    POTION_LOGIC(
        "Potion",
        Arrays.asList(
            new Heal(TargetMode.SELF, 100)
        ),
        ActionType.ITEM
    ),
    POWER_STONE_LOGIC(
        "Power Stone",
        Arrays.asList(
            new ActivateSkill()
        ),
        ActionType.ITEM
    ),
    SMOKE_BOMB_LOGIC(
        "Smoke Bomb",
        Arrays.asList(
            new ApplyEffect(TargetMode.SELF, EffectLogic.SMK_BOMB_INV)
        ),
        ActionType.ITEM
    ),
    ELIXER_LOGIC(//new feature (adds stun effect to basic attack)
        "Elixer",
        Arrays.asList(
            new EnhanceAction(
                ActionLogicType.BASIC_ATTACK_LOGIC,
                new ApplyEffect(TargetMode.TARGET, EffectLogic.STUN))
            ),
    ActionType.ITEM
    ),

    //Skill Logic
    ARCANE_BLAST_LOGIC(
        "Arcane Blast",
        Arrays.asList(
            new Damage(TargetMode.TARGET),
            new ConditionalMechanism(
                new Defeated(TargetMode.TARGET),
                new ApplyEffect(TargetMode.SELF, EffectLogic.ARC_BLAST_EFFECT))
        ),
        ActionType.SKILL
    ),
    SHELD_BASH_LOGIC(
        "Shield Bash",
        Arrays.asList(
            new Damage(TargetMode.TARGET),
            new ApplyEffect(TargetMode.TARGET, EffectLogic.STUN)
        ),
        ActionType.SKILL
    );

    private final String name;
    private List<CombatMechanism> mechanismList = new ArrayList<>();
    private ActionType actionType;

    ActionLogicType(String name, List<CombatMechanism> mechanismList, ActionType actionType){
        this.name = name;
        this.mechanismList = mechanismList;
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public List<CombatMechanism> getMechanismList() {
        return mechanismList;
    }

    public ActionType getActionType() {
        return actionType;
    }


}
