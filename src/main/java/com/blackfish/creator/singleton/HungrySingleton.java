package com.blackfish.creator.singleton;

public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("I am a hungery Singleton");
    }

    public static HungrySingleton genInstance() {
        return hungrySingleton;
    }

}
