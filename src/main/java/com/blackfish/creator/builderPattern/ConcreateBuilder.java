package com.blackfish.creator.builderPattern;

public class ConcreateBuilder implements Builder {

    private Bmsg bmsg = new Bmsg();
    private Cmsg cmsg = new Cmsg();

    @Override
    public Builder buildMessage(Amsg amsg) {
        bmsg.setId(amsg.getId());
        bmsg.setMsg("BMSG" + amsg.getMsg());
        bmsg.setExtend("BMSG EXTEND");

        cmsg.setId(amsg.getId());
        cmsg.setExtend("CMSG EXTEND");

        return this;
    }

    @Override
    public Bmsg getBmsg() {
        return bmsg;
    }

    @Override
    public Cmsg getCmsg() {
        return cmsg;
    }
}
