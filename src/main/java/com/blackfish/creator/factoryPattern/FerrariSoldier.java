package com.blackfish.creator.factoryPattern;

public class FerrariSoldier implements Soldier {

    @Override
    public void attack() {
        System.out.println("炮车兵攻击力高");
    }

    @Override
    public void defense() {
        System.out.println("炮车兵防御力高");
    }

}
