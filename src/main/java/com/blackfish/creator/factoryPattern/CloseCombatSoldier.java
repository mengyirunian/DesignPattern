package com.blackfish.creator.factoryPattern;

/**
 * 近战兵
 */
public class CloseCombatSoldier implements Soldier {

    @Override
    public void attack() {
        System.out.println("近战兵攻击力低");
    }

    @Override
    public void defense() {
        System.out.println("近战兵防御力高");
    }
}
