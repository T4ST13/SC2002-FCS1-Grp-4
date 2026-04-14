package domain.actionlogic;

import domain.actionlogic.mechanism.CombatMechanism;
import domain.combatant.Combatant;

import java.util.List;

public abstract class ActionLogic {

    private final String NAME;
    private final boolean consumeTurn;
    //private final StatusEffectLogic selfEffect, targetEffect;
    private final int maxTarget;//maxTarget = -1 for self target skills, maxTarget = 0 for skills that target all enemies
    private List<CombatMechanism> mechanisms;
    //private final boolean selfEffect, targetEffect;
    //true = status effect associated with the action is applied to the user, not the target (ex. ArcaneBlast)
    //false = status effect of the action is applied to a target (ex. ShieldBash) or the action doesn't have a status effect

    protected ActionLogic(String NAME, boolean consumeTurn, int maxTarget, List<CombatMechanism> mechanisms) {
        this.NAME = NAME;
        this.consumeTurn = consumeTurn;
        this.maxTarget = maxTarget;
        this.mechanisms = mechanisms;
    }

    /* == Getters == */
    public String getName() {
        return this.NAME;
    }

    public boolean isConsumeTurn() {
        return this.consumeTurn;
    }

    public int getMaxTarget() {
        return this.maxTarget;
    }

    public void activate(Combatant user, Combatant target) {
        for (CombatMechanism mech : this.mechanisms) {
            mech.execute(user, target);
        }
    }
}









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