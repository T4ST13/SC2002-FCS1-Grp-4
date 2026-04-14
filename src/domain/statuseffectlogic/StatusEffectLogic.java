package domain.statuseffectlogic;

import domain.combatdata.CombatStat;
import domain.combatant.Combatant;

public abstract class StatusEffectLogic {
    private final String name;
    private final CombatStat relatedStat;//the stat type that a status effect will influence
    private final int statChange;//amount by which a certain stat would be influenced by a status effect
    private final int baseDuration;//baseDuration = -1 for permanent status effects

    protected StatusEffectLogic(String name, CombatStat relatedStat, int statChange, int baseDuration) {
        this.name = name;
        this.relatedStat = relatedStat;
        this.statChange = statChange;
        this.baseDuration = baseDuration;
    }
    
    /* == Getters == */
    public String getName() {
        return this.name;
    }

    public CombatStat getRelatedStat() {
        return this.relatedStat;
    }

    public int getStatChange() {return statChange;}
    
    public int getBaseDuration(){
        return this.baseDuration;
    }

    public abstract void activate(Combatant target);
    //effects have to be implemented in each subclass (there's no common aspect between logics of different status effects )
}