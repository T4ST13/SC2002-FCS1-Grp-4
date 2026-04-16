//package domain.phase;
//
//import domain.UI.UI;
//import domain.action.Action;
//import domain.battleengine.BattleEngine;
//import domain.combatant.Combatant;
//
//public class Act extends AbstractPhase{
//    private Action action;
//    private Combatant target;
//
//    private ChooseAction chooseAction;
//    private ChooseTarget chooseTarget;
//    private ApplyAction applyAction;
//
//    public Act(BattleEngine battleEngine, UI battleUI){
//        super(battleEngine,battleUI);
//        chooseAction = new ChooseAction(battleEngine, battleUI);
//    }
//
//    public boolean canEnter(){
//        return chooseAction.canEnter();
//    }
//
//    public void execute(){
//        if (chooseAction.canEnter())
//            chooseAction.execute();
//        this.action = chooseAction.getAction();
//
//        chooseTarget = new ChooseTarget(
//            this.getEngine(),
//            this.getBattleUI(),
//            this.action
//        );
//        if (chooseTarget.canEnter())
//            chooseTarget.execute();
//        this.target = chooseTarget.getTarget();
//
//        applyAction = new ApplyAction(
//            this.getEngine(),
//            this.getBattleUI(),
//            this.action,
//            this.target
//        );
//        if (applyAction.canEnter())
//            applyAction.execute();;
//        this.setDone();
//    }
//
//    public void setDone(){
//        if (this.action.isConsumeTurn()){
//            super.setDone();
//        }
//    }
//}
