package com.blackfish.creator.builderPattern;

public class Director {

    private Builder builder = new ConcreateBuilder();

    public Bmsg getBmsg(Amsg amsg) {
        return builder.buildMessage(amsg).getBmsg();
    }

    public Cmsg getCmsg(Amsg amsg) {
        return builder.buildMessage(amsg).getCmsg();
    }

}
