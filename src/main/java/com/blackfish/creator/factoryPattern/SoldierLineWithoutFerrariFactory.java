package com.blackfish.creator.factoryPattern;

import com.google.common.collect.Lists;

import java.util.List;

public class SoldierLineWithoutFerrariFactory extends SoldierLineCommonFactory {

    @Override
    public List<Soldier> createFerrariSoldier() {
        return Lists.newArrayList();
    }

}
