package com.blackfish.creator.factoryPattern;

public class FerrariSoldierFactory implements SoldierFactory {

    @Override
    public Soldier createSoldier() {
        return new FerrariSoldier();
    }

}
