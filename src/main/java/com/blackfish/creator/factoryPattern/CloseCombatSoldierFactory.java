package com.blackfish.creator.factoryPattern;

public class CloseCombatSoldierFactory implements SoldierFactory {

    @Override
    public Soldier createSoldier() {
        return new CloseCombatSoldier();
    }
}
