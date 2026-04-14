package domain.statuseffectlogic;

public enum StatusEffectType{
    //from shared actions
    DEFEND_EFFECT(
        "Defend Effect", 
        2,
        Arrays.asList(
            new Buff(CombatStat.DEF, 10)
        )
    ),

    //from items
    SMK_BOMB_INV(
        "Smoke Bomb Invulnerability",
        2,
        Arrays.asList(
            //new DamageModifier(...)
        )
    ),

    //from skills
    ARC_BLAST_EFFECT(
        "Arcane Blast Effect",
        -1,
        Arrays.asList(
            new Buff(CombatStat.ATK, 10)
        )
    ),
    STUN(
        "Stun",
        2,
        Arrays.asList(
            //new ActionPrevention(...)
        )
    );

    ARC_BLAST_EFFECT("")

    private final String name;
    private final int baseDuration;//add conditional mechanism for statuseffects that dissapear on conditions (will have to place it in front of mech list and also prevent reading through mech that comes after)
    private final List<CombatMechanism> effectLogic = new ArrayList<>();

    StatusEffectType(String name, int baseDuration, List<CombatMechanism> effectLogic){
        this.name = name;
        this.baseDuration = baseDuration;
        this.effectLogic = effectLogic; 
    }



}