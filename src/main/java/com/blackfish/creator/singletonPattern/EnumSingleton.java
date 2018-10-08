package com.blackfish.creator.singletonPattern;

public class EnumSingleton {

    private enum Singleton {
        SINGLETON;
        private Object target;

        private Singleton () {
            target = new Object();
        }

        public Object getObject() {
            return target;
        }

    }

    public static Object getObject() {
        return Singleton.SINGLETON.getObject();
    }

}
