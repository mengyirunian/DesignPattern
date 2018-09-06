package com.blackfish.creator.factoryPattern;

public class LongDistanceSoldierFactory implements SoldierFactory {

    @Override
    public Soldier createSoldier() {
        return new LongDistanceSoldier();
    }

}
