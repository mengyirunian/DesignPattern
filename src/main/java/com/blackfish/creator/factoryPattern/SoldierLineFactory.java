package com.blackfish.creator.factoryPattern;

import java.util.List;

public interface SoldierLineFactory {

    List<Soldier> createCloseCombatSoldier();

    List<Soldier> createFerrariSoldier();

    List<Soldier> createLongDistanceSoldier();

}
