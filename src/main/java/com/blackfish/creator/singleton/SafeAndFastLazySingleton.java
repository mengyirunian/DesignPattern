package com.blackfish.creator.singleton;

public class SafeAndFastLazySingleton {

    private volatile static SafeAndFastLazySingleton safeAndFastLazySingleton = null;

    private SafeAndFastLazySingleton () {
        System.out.println("I am a safety and fast Lazy Singleton. I cannot be created until you want me!");
    }

    public static SafeAndFastLazySingleton getInstance() {
        if (safeAndFastLazySingleton == null) {
            synchronized (SafeAndFastLazySingleton.class) {
                if (safeAndFastLazySingleton == null) {
                    safeAndFastLazySingleton = new SafeAndFastLazySingleton();
                }
            }
        }
        return safeAndFastLazySingleton;
    }

}
