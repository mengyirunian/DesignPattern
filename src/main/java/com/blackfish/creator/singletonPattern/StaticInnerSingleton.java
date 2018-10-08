package com.blackfish.creator.singletonPattern;

public class StaticInnerSingleton {

    private static class Holder {
        private static StaticInnerSingleton singleton = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
        System.out.println("I am a static inner singletonPattern");
    }

    public static StaticInnerSingleton getInstance() {
        return Holder.singleton;
    }

}
