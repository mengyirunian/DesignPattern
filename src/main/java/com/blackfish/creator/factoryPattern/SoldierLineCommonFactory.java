package com.blackfish.creator.factoryPattern;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class SoldierLineCommonFactory implements SoldierLineFactory {

    @Override
    public List<Soldier> createCloseCombatSoldier() {
        List<Soldier> closeCombatSoldiers = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            closeCombatSoldiers.add(new CloseCombatSoldier());
        }
        return closeCombatSoldiers;
    }

    @Override
    public List<Soldier> createLongDistanceSoldier() {
        List<Soldier> longDistanceSoldiers = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            longDistanceSoldiers.add(new LongDistanceSoldier());
        }
        return longDistanceSoldiers;
    }

}
