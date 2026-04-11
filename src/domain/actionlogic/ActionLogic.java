package domain.actionlogic;

// Need to import classes since we using protected
import domain.DamageCalc;
import domain.combatant.Combatant;
import domain.statuseffect.StatusEffect;
import domain.statuseffectlogic.StatusEffectLogic;

public abstract class ActionLogic {

    private final String NAME;
    private final boolean consumeTurn;
    private final StatusEffectLogic effectLogic;
    private int maxTarget;//maxTarget = -1 for self target skills, maxTarget = 0 for skills that target all enemies
    private final boolean effectSelf;
    //true = status effect associated with the action is applied to the user, not the target (ex. ArcaneBlast)
    //false = status effect of the action is applied to a target (ex. ShieldBash) or the action doesn't have a status effect

    protected ActionLogic(String NAME, boolean consumeTurn, StatusEffectLogic effectLogic, int maxTarget, boolean effectSelf) {
        this.NAME = NAME;
        this.consumeTurn = consumeTurn;
        this.effectLogic = effectLogic;
        this.maxTarget = maxTarget;
        this.effectSelf = effectSelf;
    }

    /* == Getters == */
    public String getName() {
        return this.NAME;
    }

    public StatusEffectLogic getEffectLogic() {
        return this.effectLogic;
    }

    public boolean isConsumeTurn() {
        return this.consumeTurn;
    }

    public int getMaxTarget(){
        return this.maxTarget;
    }

    public boolean isEffectSelf(){
        return this.effectSelf;
    }

    public void applyEffect(Combatant target){
        if (this.effectLogic != null) {
            target.addStatusEffect(new StatusEffect(this.effectLogic, this.effectLogic.getBaseDuration()));
        }
    }

    public void activate(Combatant user, Combatant target){
        int damage = DamageCalc.calculate(user, target);
        if (damage<0){
            target.heal(damage);
        }
        else{
            target.takeDamage(damage);
        }
        if (this.isEffectSelf()) {
            this.applyEffect(user);
        } else {
            this.applyEffect(target);
        }
    }
}