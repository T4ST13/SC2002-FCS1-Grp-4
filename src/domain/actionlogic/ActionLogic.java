package domain.actionlogic;

import domain.combatant.Combatant;
import domain.combatmechanism.CombatMechanism;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionLogic{

    ActionLogicType logicType;
    private final boolean consumeTurn;

    protected ActionLogic(ActionLogicType logicType, boolean consumeTurn) {//might need to include consumeTurn into enum
        this.logicType = logicType;
        this.consumeTurn = consumeTurn;
    }

    /* == Getters == */
    public ActionLogicType getLogicType(){
        return logicType;
    }
    public String getName() {
        return this.logicType.getName();
    }

    public boolean isConsumeTurn() {
        return this.consumeTurn;
    }

    public boolean needsTarget(Combatant user) {
        for (CombatMechanism mechanism : logicType.getMechanismList()){
            if (mechanism.needsTarget(user)){
                return true;
            }
        }
        return false;
        //return this.logicType.needsTarget(user);
    }

    public /*List<String>*/ void activate(Combatant user, Combatant target) {
//        List<String> messages = new ArrayList<>();
//        for (CombatMechanism mechanism : this.logicType.getMechanismList()) {
//            messages.add(mechanism.execute(user, target));
//        }
//        return messages;
        for (CombatMechanism mechanism : this.logicType.getMechanismList()) {
            mechanism.execute(user, target);
        }
    }
}





















//original constructor
//    protected ActionLogic(String NAME, boolean consumeTurn, int maxTarget, List<CombatMechanism> mechanisms) {
//        this.NAME = NAME;
//        this.consumeTurn = consumeTurn;
//        this.maxTarget = maxTarget;
//        this.mechanisms = mechanisms;
//    }

//    public void applyEffect(Combatant target){
//        if (this.effectLogic != null) {
//            target.addStatusEffect(new StatusEffect(this.effectLogic, this.effectLogic.getBaseDuration()));
//        }
//    }

//    public void activate(Combatant user, Combatant target){
//        int damage = DamageCalc.calculate(user, target);
//        if (damage<0){
//            target.heal(damage);
//        }
//        else{
//            target.takeDamage(damage);
//        }
//        if (this.isEffectSelf()) {
//            this.applyEffect(user);
//        } else {
//            this.applyEffect(target);
//        }
//    }