package com.blackfish.creator.factoryPattern;

public class SimpleSoldierFactory {

    public static Soldier createSoldier(int type) {
        Soldier target = null;
        switch (type) {
            case 1:
                target = new CloseCombatSoldier();
                break;
            case 2:
                target = new LongDistanceSoldier();
                break;
            /*
            case 3:
                target = new FerrariSoldier();
                break;
            */
            default:
                break;
        }
        return target;
    }

}
