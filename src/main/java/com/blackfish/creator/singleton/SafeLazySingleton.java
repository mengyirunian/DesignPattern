package com.blackfish.creator.singleton;

public class SafeLazySingleton {

    private static SafeLazySingleton safeLazySingleton = null;

    private SafeLazySingleton() {
        System.out.println("I am a safety Lazy Singleton. I cannot be created until you want me!");
    }

    public synchronized static SafeLazySingleton getInstance1() {
        if (safeLazySingleton == null) {
            safeLazySingleton = new SafeLazySingleton();
        }
        return safeLazySingleton;
    }

    public static SafeLazySingleton getInstance2() {
        synchronized (SafeLazySingleton.class) {
            if (safeLazySingleton == null) {
                safeLazySingleton = new SafeLazySingleton();
            }
        }
        return safeLazySingleton;
    }

}
