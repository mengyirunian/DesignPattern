package com.blackfish.creator.factoryPattern;

public class LongDistanceSoldier implements Soldier {

    @Override
    public void attack() {
        System.out.println("远程兵攻击力高");
    }

    @Override
    public void defense() {
        System.out.println("远程兵防御力低");
    }
}
