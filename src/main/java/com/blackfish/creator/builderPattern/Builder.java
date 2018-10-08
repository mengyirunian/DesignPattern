package com.blackfish.creator.builderPattern;

public interface Builder {

    Builder buildMessage(Amsg amsg);

    Bmsg getBmsg();

    Cmsg getCmsg();

}
