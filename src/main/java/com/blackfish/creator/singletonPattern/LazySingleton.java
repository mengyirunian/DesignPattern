package com.blackfish.creator.singletonPattern;

public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        System.out.println("I am a Lazy Singleton. I cannot be created until you want me!");
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
